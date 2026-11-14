package cu.z17.views.picture;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.runtime.Composable;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.R;
import defpackage.r;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", NewEntity.NEWS_CONFIG_SOURCE, "placeholder", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "", "description", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "", "customHeaders", "blurHash", "Lua/k0;", "Z17BasePicture-C8z9wKI", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Z17BasePicture", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PictureKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:112:0x0143  */
    /* JADX WARN: Code duplicated, block: B:114:0x0147  */
    /* JADX WARN: Code duplicated, block: B:115:0x0150  */
    /* JADX WARN: Code duplicated, block: B:117:0x0154  */
    /* JADX WARN: Code duplicated, block: B:119:0x0157  */
    /* JADX WARN: Code duplicated, block: B:120:0x015e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0163  */
    /* JADX WARN: Code duplicated, block: B:126:0x0168  */
    /* JADX WARN: Code duplicated, block: B:127:0x0171  */
    /* JADX WARN: Code duplicated, block: B:129:0x0174  */
    /* JADX WARN: Code duplicated, block: B:130:0x0176  */
    /* JADX WARN: Code duplicated, block: B:133:0x017f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0186  */
    /* JADX WARN: Code duplicated, block: B:137:0x0194  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:149:0x0205  */
    /* JADX WARN: Code duplicated, block: B:152:0x0223  */
    /* JADX WARN: Code duplicated, block: B:155:0x0258  */
    /* JADX WARN: Code duplicated, block: B:157:0x0262  */
    /* JADX WARN: Code duplicated, block: B:170:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:172:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:173:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:175:0x0303  */
    /* JADX WARN: Code duplicated, block: B:177:0x0362  */
    /* JADX WARN: Code duplicated, block: B:179:0x0369  */
    /* JADX WARN: Code duplicated, block: B:180:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:184:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:186:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:188:0x0402  */
    /* JADX WARN: Code duplicated, block: B:190:0x0414  */
    /* JADX WARN: Code duplicated, block: B:192:0x045a  */
    /* JADX WARN: Code duplicated, block: B:194:0x045e  */
    /* JADX WARN: Code duplicated, block: B:196:0x0476  */
    /* JADX WARN: Code duplicated, block: B:198:0x047e  */
    /* JADX WARN: Code duplicated, block: B:200:0x0491  */
    /* JADX WARN: Code duplicated, block: B:203:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:205:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:208:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x010c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0115  */
    @Composable
    /* JADX INFO: renamed from: Z17BasePicture-C8z9wKI, reason: not valid java name */
    public static final void m10278Z17BasePictureC8z9wKI(final Modifier modifier, final Object obj, Object obj2, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Map<String, String> map, String str2, Composer composer, final int i11, final int i12) {
        int i13;
        ColorFilter colorFilter2;
        int i14;
        ContentScale contentScale2;
        int i15;
        int i16;
        String str3;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z10;
        final Object obj3;
        final String str4;
        final ColorFilter colorFilter3;
        final ContentScale contentScale3;
        final String str5;
        final int i23;
        final Map<String, String> map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object image;
        ContentScale fit;
        int iM5965getHighfv9h1I;
        Map<String, String> map3;
        Object obj4;
        String str6;
        ContentScale contentScale4;
        int i24;
        Map<String, String> map4;
        ColorFilter colorFilter4;
        String str7;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        String str8;
        Function2 setCompositeKeyHash;
        String str9;
        Object obj5;
        ColorFilter colorFilter5;
        Map<String, String> map5;
        int i25;
        boolean zChangedInstance;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object obj6;
        Object objRememberedValue3;
        Object obj7;
        y.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(330630401);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= ((i12 & 4) == 0 && composerStartRestartGroup.changedInstance(obj2)) ? 256 : 128;
        }
        int i26 = i12 & 8;
        if (i26 == 0) {
            if ((i11 & 3072) == 0) {
                colorFilter2 = colorFilter;
                i13 |= composerStartRestartGroup.changed(colorFilter2) ? 2048 : 1024;
            }
            i14 = i12 & 16;
            if (i14 != 0) {
                if ((i11 & 24576) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
                    }
                    i13 |= i15;
                }
                i16 = i12 & 32;
                if (i16 != 0) {
                    if ((196608 & i11) == 0) {
                        str3 = str;
                        if (composerStartRestartGroup.changed(str3)) {
                            i17 = 131072;
                        } else {
                            i17 = 65536;
                        }
                        i13 |= i17;
                    }
                    if ((1572864 & i11) == 0) {
                        if ((i12 & 64) == 0) {
                            i18 = i10;
                            int i27 = composerStartRestartGroup.changed(i18) ? 1048576 : 524288;
                            i13 |= i27;
                        } else {
                            i18 = i10;
                        }
                        i13 |= i27;
                    } else {
                        i18 = i10;
                    }
                    i19 = i12 & 128;
                    if (i19 != 0) {
                        i13 |= 12582912;
                    } else if ((i11 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(map)) {
                            i20 = 8388608;
                        } else {
                            i20 = 4194304;
                        }
                        i13 |= i20;
                    }
                    i21 = i12 & 256;
                    if (i21 != 0) {
                        if ((i11 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(str2)) {
                                i22 = 67108864;
                            } else {
                                i22 = 33554432;
                            }
                            i13 |= i22;
                        }
                        if ((i13 & 38347923) != 38347922) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i11 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if ((i12 & 4) != 0) {
                                    image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                    i13 &= -897;
                                } else {
                                    image = obj2;
                                }
                                if (i26 != 0) {
                                    colorFilter2 = null;
                                }
                                if (i14 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                } else {
                                    fit = contentScale2;
                                }
                                if (i16 != 0) {
                                    str3 = "";
                                }
                                if ((i12 & 64) != 0) {
                                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                    i13 &= -3670017;
                                } else {
                                    iM5965getHighfv9h1I = i18;
                                }
                                if (i19 != 0) {
                                    map3 = null;
                                } else {
                                    map3 = map;
                                }
                                String str10 = str3;
                                obj4 = image;
                                str6 = str10;
                                contentScale4 = fit;
                                if (i21 != 0) {
                                    i24 = iM5965getHighfv9h1I;
                                    map4 = map3;
                                    colorFilter4 = colorFilter2;
                                    str7 = "";
                                } else {
                                    i24 = iM5965getHighfv9h1I;
                                    map4 = map3;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                                }
                                int i28 = i13 & 14;
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
                                composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                                str8 = str6;
                                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                if (obj == null || str7.length() <= 0) {
                                    str9 = str8;
                                    if ((obj instanceof String) || ((CharSequence) obj).length() <= 0) {
                                        obj5 = obj4;
                                        colorFilter5 = colorFilter4;
                                        map5 = map4;
                                        if (obj instanceof Uri) {
                                            composerStartRestartGroup.startReplaceGroup(1075859374);
                                            int i29 = i13 >> 6;
                                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i29 & 896) | 6 | (i29 & 7168) | (i29 & 57344), 32);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            if (obj instanceof Integer) {
                                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                                int i30 = i24;
                                                ContentScale contentScale5 = contentScale4;
                                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale5, 0.0f, colorFilter5, i30, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                                str9 = str9;
                                                contentScale4 = contentScale5;
                                                colorFilter4 = colorFilter5;
                                                i25 = i30;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                colorFilter4 = colorFilter5;
                                                i25 = i24;
                                                if (obj instanceof ImageVector) {
                                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                                    ContentScale contentScale6 = contentScale4;
                                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale6, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                                    str9 = str9;
                                                    contentScale4 = contentScale6;
                                                    colorFilter4 = colorFilter4;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else if (obj instanceof Bitmap) {
                                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        obj7 = objRememberedValue3;
                                                        Bitmap bitmap = (Bitmap) obj;
                                                        bitmap.prepareToDraw();
                                                        composerStartRestartGroup.updateRememberedValue(bitmap);
                                                        obj7 = bitmap;
                                                    }
                                                    obj7 = objRememberedValue3;
                                                    int i31 = i13 >> 6;
                                                    i24 = i25;
                                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31 & 112) | 6 | (i31 & 896) | (i31 & 7168) | (i31 & 57344), 64);
                                                    str9 = str9;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    i24 = i25;
                                                    if (obj instanceof Drawable) {
                                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                            obj6 = objRememberedValue2;
                                                            Bitmap bitmap$default = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                            bitmap$default.prepareToDraw();
                                                            composerStartRestartGroup.updateRememberedValue(bitmap$default);
                                                            obj6 = bitmap$default;
                                                        }
                                                        obj6 = objRememberedValue2;
                                                        int i32 = i13 >> 6;
                                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i32 & 112) | 6 | (i32 & 896) | (i32 & 7168) | (i32 & 57344), 64);
                                                        str9 = str9;
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else if (obj instanceof Color) {
                                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj8) {
                                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                        }
                                                        CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else {
                                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                                        int i33 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                        ContentScale contentScale7 = contentScale4;
                                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale7, str9, i24, null, null, composerStartRestartGroup, i33, 388);
                                                        colorFilter4 = colorFilter4;
                                                        contentScale4 = contentScale7;
                                                        i24 = i24;
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                        }
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1075280170);
                                        ColorFilter colorFilter6 = colorFilter4;
                                        obj5 = obj4;
                                        int i34 = i24;
                                        ContentScale contentScale8 = contentScale4;
                                        Z17PictureSourceKt.m10281PictureFromUrlPx5SB0(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (String) obj, ((obj4 instanceof Integer) || (obj4 instanceof Drawable) || (obj4 instanceof Color)) ? obj4 : Integer.valueOf(R.drawable.placeholder), colorFilter6, contentScale8, str9, i34, map4, composerStartRestartGroup, (57344 & i13) | (i13 & 7168) | 6 | (i13 & 458752) | (3670016 & i13) | (i13 & 29360128), 0);
                                        colorFilter5 = colorFilter6;
                                        contentScale4 = contentScale8;
                                        i24 = i34;
                                        map5 = map4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    colorFilter4 = colorFilter5;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1074881417);
                                    int i35 = i13 >> 6;
                                    Z17PictureSourceKt.m10282PictureWithBlurHash6tVf_Uk(modifier, null, contentScale4, str8, i24, str7, null, composerStartRestartGroup, (57344 & i35) | i28 | 48 | (i35 & 896) | (i35 & 7168) | (458752 & (i13 >> 9)), 64);
                                    str9 = str8;
                                    composerStartRestartGroup.endReplaceGroup();
                                    obj5 = obj4;
                                    map5 = map4;
                                }
                                composerStartRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                obj3 = obj5;
                                map2 = map5;
                                colorFilter3 = colorFilter4;
                                i23 = i24;
                                str5 = str9;
                                str4 = str7;
                                contentScale3 = contentScale4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i12 & 4) != 0) {
                                    i13 &= -897;
                                }
                                if ((i12 & 64) != 0) {
                                    i13 &= -3670017;
                                }
                                map4 = map;
                                contentScale4 = contentScale2;
                                str6 = str3;
                                i24 = i18;
                                obj4 = obj2;
                            }
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                            }
                            int i210 = i13 & 14;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
                            str8 = str6;
                            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (composerM5176constructorimpl.getInserting()) {
                                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            if (obj == null) {
                                str9 = str8;
                                if (obj instanceof String) {
                                    obj5 = obj4;
                                    colorFilter5 = colorFilter4;
                                    map5 = map4;
                                    if (obj instanceof Uri) {
                                        composerStartRestartGroup.startReplaceGroup(1075859374);
                                        int i211 = i13 >> 6;
                                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211 & 896) | 6 | (i211 & 7168) | (i211 & 57344), 32);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                        colorFilter4 = colorFilter5;
                                    } else {
                                        if (obj instanceof Integer) {
                                            composerStartRestartGroup.startReplaceGroup(1076190330);
                                            int i36 = i24;
                                            ContentScale contentScale9 = contentScale4;
                                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale9, 0.0f, colorFilter5, i36, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                            str9 = str9;
                                            contentScale4 = contentScale9;
                                            colorFilter4 = colorFilter5;
                                            i25 = i36;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            colorFilter4 = colorFilter5;
                                            i25 = i24;
                                            if (obj instanceof ImageVector) {
                                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                                ContentScale contentScale10 = contentScale4;
                                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale10, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                                str9 = str9;
                                                contentScale4 = contentScale10;
                                                colorFilter4 = colorFilter4;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Bitmap) {
                                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    obj7 = objRememberedValue3;
                                                    Bitmap bitmap2 = (Bitmap) obj;
                                                    bitmap2.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap2);
                                                    obj7 = bitmap2;
                                                }
                                                obj7 = objRememberedValue3;
                                                int i37 = i13 >> 6;
                                                i24 = i25;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i37 & 112) | 6 | (i37 & 896) | (i37 & 7168) | (i37 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                i24 = i25;
                                                if (obj instanceof Drawable) {
                                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        obj6 = objRememberedValue2;
                                                        Bitmap bitmap$default2 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                        bitmap$default2.prepareToDraw();
                                                        composerStartRestartGroup.updateRememberedValue(bitmap$default2);
                                                        obj6 = bitmap$default2;
                                                    }
                                                    obj6 = objRememberedValue2;
                                                    int i38 = i13 >> 6;
                                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i38 & 112) | 6 | (i38 & 896) | (i38 & 7168) | (i38 & 57344), 64);
                                                    str9 = str9;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else if (obj instanceof Color) {
                                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance) {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    } else {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    }
                                                    CanvasKt.Canvas(modifierFillMaxSize$default2, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                                    int i39 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                    ContentScale contentScale11 = contentScale4;
                                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11, str9, i24, null, null, composerStartRestartGroup, i39, 388);
                                                    colorFilter4 = colorFilter4;
                                                    contentScale4 = contentScale11;
                                                    i24 = i24;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        }
                                        i24 = i25;
                                    }
                                } else {
                                    obj5 = obj4;
                                    colorFilter5 = colorFilter4;
                                    map5 = map4;
                                    if (obj instanceof Uri) {
                                        composerStartRestartGroup.startReplaceGroup(1075859374);
                                        int i212 = i13 >> 6;
                                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i212 & 896) | 6 | (i212 & 7168) | (i212 & 57344), 32);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                        colorFilter4 = colorFilter5;
                                    } else {
                                        if (obj instanceof Integer) {
                                            composerStartRestartGroup.startReplaceGroup(1076190330);
                                            int i310 = i24;
                                            ContentScale contentScale12 = contentScale4;
                                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale12, 0.0f, colorFilter5, i310, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                            str9 = str9;
                                            contentScale4 = contentScale12;
                                            colorFilter4 = colorFilter5;
                                            i25 = i310;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            colorFilter4 = colorFilter5;
                                            i25 = i24;
                                            if (obj instanceof ImageVector) {
                                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                                ContentScale contentScale13 = contentScale4;
                                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale13, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                                str9 = str9;
                                                contentScale4 = contentScale13;
                                                colorFilter4 = colorFilter4;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Bitmap) {
                                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    obj7 = objRememberedValue3;
                                                    Bitmap bitmap3 = (Bitmap) obj;
                                                    bitmap3.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap3);
                                                    obj7 = bitmap3;
                                                }
                                                obj7 = objRememberedValue3;
                                                int i311 = i13 >> 6;
                                                i24 = i25;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311 & 112) | 6 | (i311 & 896) | (i311 & 7168) | (i311 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                i24 = i25;
                                                if (obj instanceof Drawable) {
                                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        obj6 = objRememberedValue2;
                                                        Bitmap bitmap$default3 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                        bitmap$default3.prepareToDraw();
                                                        composerStartRestartGroup.updateRememberedValue(bitmap$default3);
                                                        obj6 = bitmap$default3;
                                                    }
                                                    obj6 = objRememberedValue2;
                                                    int i312 = i13 >> 6;
                                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i312 & 112) | 6 | (i312 & 896) | (i312 & 7168) | (i312 & 57344), 64);
                                                    str9 = str9;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else if (obj instanceof Color) {
                                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance) {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    } else {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    }
                                                    CanvasKt.Canvas(modifierFillMaxSize$default3, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                                    int i313 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                    ContentScale contentScale14 = contentScale4;
                                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale14, str9, i24, null, null, composerStartRestartGroup, i313, 388);
                                                    colorFilter4 = colorFilter4;
                                                    contentScale4 = contentScale14;
                                                    i24 = i24;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        }
                                        i24 = i25;
                                    }
                                }
                            } else {
                                str9 = str8;
                                if (obj instanceof String) {
                                    obj5 = obj4;
                                    colorFilter5 = colorFilter4;
                                    map5 = map4;
                                    if (obj instanceof Uri) {
                                        composerStartRestartGroup.startReplaceGroup(1075859374);
                                        int i213 = i13 >> 6;
                                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i213 & 896) | 6 | (i213 & 7168) | (i213 & 57344), 32);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                        colorFilter4 = colorFilter5;
                                    } else {
                                        if (obj instanceof Integer) {
                                            composerStartRestartGroup.startReplaceGroup(1076190330);
                                            int i314 = i24;
                                            ContentScale contentScale15 = contentScale4;
                                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale15, 0.0f, colorFilter5, i314, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                            str9 = str9;
                                            contentScale4 = contentScale15;
                                            colorFilter4 = colorFilter5;
                                            i25 = i314;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            colorFilter4 = colorFilter5;
                                            i25 = i24;
                                            if (obj instanceof ImageVector) {
                                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                                ContentScale contentScale16 = contentScale4;
                                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale16, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                                str9 = str9;
                                                contentScale4 = contentScale16;
                                                colorFilter4 = colorFilter4;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Bitmap) {
                                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    obj7 = objRememberedValue3;
                                                    Bitmap bitmap4 = (Bitmap) obj;
                                                    bitmap4.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap4);
                                                    obj7 = bitmap4;
                                                }
                                                obj7 = objRememberedValue3;
                                                int i315 = i13 >> 6;
                                                i24 = i25;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i315 & 112) | 6 | (i315 & 896) | (i315 & 7168) | (i315 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                i24 = i25;
                                                if (obj instanceof Drawable) {
                                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        obj6 = objRememberedValue2;
                                                        Bitmap bitmap$default4 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                        bitmap$default4.prepareToDraw();
                                                        composerStartRestartGroup.updateRememberedValue(bitmap$default4);
                                                        obj6 = bitmap$default4;
                                                    }
                                                    obj6 = objRememberedValue2;
                                                    int i316 = i13 >> 6;
                                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i316 & 112) | 6 | (i316 & 896) | (i316 & 7168) | (i316 & 57344), 64);
                                                    str9 = str9;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else if (obj instanceof Color) {
                                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                                    Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance) {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    } else {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    }
                                                    CanvasKt.Canvas(modifierFillMaxSize$default4, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                                    int i317 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                    ContentScale contentScale17 = contentScale4;
                                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale17, str9, i24, null, null, composerStartRestartGroup, i317, 388);
                                                    colorFilter4 = colorFilter4;
                                                    contentScale4 = contentScale17;
                                                    i24 = i24;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        }
                                        i24 = i25;
                                    }
                                } else {
                                    obj5 = obj4;
                                    colorFilter5 = colorFilter4;
                                    map5 = map4;
                                    if (obj instanceof Uri) {
                                        composerStartRestartGroup.startReplaceGroup(1075859374);
                                        int i214 = i13 >> 6;
                                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i214 & 896) | 6 | (i214 & 7168) | (i214 & 57344), 32);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                        colorFilter4 = colorFilter5;
                                    } else {
                                        if (obj instanceof Integer) {
                                            composerStartRestartGroup.startReplaceGroup(1076190330);
                                            int i318 = i24;
                                            ContentScale contentScale18 = contentScale4;
                                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale18, 0.0f, colorFilter5, i318, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                            str9 = str9;
                                            contentScale4 = contentScale18;
                                            colorFilter4 = colorFilter5;
                                            i25 = i318;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            colorFilter4 = colorFilter5;
                                            i25 = i24;
                                            if (obj instanceof ImageVector) {
                                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                                ContentScale contentScale19 = contentScale4;
                                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale19, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                                str9 = str9;
                                                contentScale4 = contentScale19;
                                                colorFilter4 = colorFilter4;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Bitmap) {
                                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    obj7 = objRememberedValue3;
                                                    Bitmap bitmap5 = (Bitmap) obj;
                                                    bitmap5.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap5);
                                                    obj7 = bitmap5;
                                                }
                                                obj7 = objRememberedValue3;
                                                int i319 = i13 >> 6;
                                                i24 = i25;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i319 & 112) | 6 | (i319 & 896) | (i319 & 7168) | (i319 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                i24 = i25;
                                                if (obj instanceof Drawable) {
                                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        obj6 = objRememberedValue2;
                                                        Bitmap bitmap$default5 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                        bitmap$default5.prepareToDraw();
                                                        composerStartRestartGroup.updateRememberedValue(bitmap$default5);
                                                        obj6 = bitmap$default5;
                                                    }
                                                    obj6 = objRememberedValue2;
                                                    int i3110 = i13 >> 6;
                                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3110 & 112) | 6 | (i3110 & 896) | (i3110 & 7168) | (i3110 & 57344), 64);
                                                    str9 = str9;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else if (obj instanceof Color) {
                                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance) {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    } else {
                                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj8) {
                                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    }
                                                    CanvasKt.Canvas(modifierFillMaxSize$default5, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                                    int i3111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                    ContentScale contentScale110 = contentScale4;
                                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale110, str9, i24, null, null, composerStartRestartGroup, i3111, 388);
                                                    colorFilter4 = colorFilter4;
                                                    contentScale4 = contentScale110;
                                                    i24 = i24;
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        }
                                        i24 = i25;
                                    }
                                }
                            }
                            composerStartRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            obj3 = obj5;
                            map2 = map5;
                            colorFilter3 = colorFilter4;
                            i23 = i24;
                            str5 = str9;
                            str4 = str7;
                            contentScale3 = contentScale4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            obj3 = obj2;
                            str4 = str2;
                            colorFilter3 = colorFilter2;
                            contentScale3 = contentScale2;
                            str5 = str3;
                            i23 = i18;
                            map2 = map;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj8, Object obj9) {
                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 100663296;
                    if ((i13 & 38347923) != 38347922) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str11 = str3;
                            obj4 = image;
                            str6 = str11;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        } else {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str12 = str3;
                            obj4 = image;
                            str6 = str12;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                        }
                        int i215 = i13 & 14;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
                        str8 = str6;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting()) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier3, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        if (obj == null) {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i216 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i216 & 896) | 6 | (i216 & 7168) | (i216 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3112 = i24;
                                        ContentScale contentScale111 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111, 0.0f, colorFilter5, i3112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale111;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3112;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale112 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale112;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap6 = (Bitmap) obj;
                                                bitmap6.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap6);
                                                obj7 = bitmap6;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3113 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3113 & 112) | 6 | (i3113 & 896) | (i3113 & 7168) | (i3113 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default6 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default6.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default6);
                                                    obj6 = bitmap$default6;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3114 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3114 & 112) | 6 | (i3114 & 896) | (i3114 & 7168) | (i3114 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default6, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale113 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale113, str9, i24, null, null, composerStartRestartGroup, i3115, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale113;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i217 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i217 & 896) | 6 | (i217 & 7168) | (i217 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3116 = i24;
                                        ContentScale contentScale114 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale114, 0.0f, colorFilter5, i3116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale114;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3116;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale115 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale115;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap7 = (Bitmap) obj;
                                                bitmap7.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap7);
                                                obj7 = bitmap7;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3117 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3117 & 112) | 6 | (i3117 & 896) | (i3117 & 7168) | (i3117 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default7 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default7.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default7);
                                                    obj6 = bitmap$default7;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3118 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3118 & 112) | 6 | (i3118 & 896) | (i3118 & 7168) | (i3118 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default7, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale116 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale116, str9, i24, null, null, composerStartRestartGroup, i3119, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale116;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        } else {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i218 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i218 & 896) | 6 | (i218 & 7168) | (i218 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i31110 = i24;
                                        ContentScale contentScale117 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale117, 0.0f, colorFilter5, i31110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale117;
                                        colorFilter4 = colorFilter5;
                                        i25 = i31110;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale118 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale118;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap8 = (Bitmap) obj;
                                                bitmap8.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap8);
                                                obj7 = bitmap8;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i31111 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111 & 112) | 6 | (i31111 & 896) | (i31111 & 7168) | (i31111 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default8 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default8.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default8);
                                                    obj6 = bitmap$default8;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i31112 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31112 & 112) | 6 | (i31112 & 896) | (i31112 & 7168) | (i31112 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default8, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i31113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale119 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale119, str9, i24, null, null, composerStartRestartGroup, i31113, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale119;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i219 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i219 & 896) | 6 | (i219 & 7168) | (i219 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i31114 = i24;
                                        ContentScale contentScale1110 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1110, 0.0f, colorFilter5, i31114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1110;
                                        colorFilter4 = colorFilter5;
                                        i25 = i31114;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1111 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1111;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap9 = (Bitmap) obj;
                                                bitmap9.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap9);
                                                obj7 = bitmap9;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i31115 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31115 & 112) | 6 | (i31115 & 896) | (i31115 & 7168) | (i31115 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default9 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default9.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default9);
                                                    obj6 = bitmap$default9;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i31116 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31116 & 112) | 6 | (i31116 & 896) | (i31116 & 7168) | (i31116 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default9, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i31117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1112 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1112, str9, i24, null, null, composerStartRestartGroup, i31117, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1112;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj3 = obj5;
                        map2 = map5;
                        colorFilter3 = colorFilter4;
                        i23 = i24;
                        str5 = str9;
                        str4 = str7;
                        contentScale3 = contentScale4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj3 = obj2;
                        str4 = str2;
                        colorFilter3 = colorFilter2;
                        contentScale3 = contentScale2;
                        str5 = str3;
                        i23 = i18;
                        map2 = map;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj8, Object obj9) {
                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                            }
                        });
                    }
                }
                i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str3 = str;
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        i18 = i10;
                        if (composerStartRestartGroup.changed(i18)) {
                        }
                        i13 |= i27;
                    } else {
                        i18 = i10;
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i19 = i12 & 128;
                if (i19 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(map)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i13 |= i20;
                }
                i21 = i12 & 256;
                if (i21 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str2)) {
                            i22 = 67108864;
                        } else {
                            i22 = 33554432;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str13 = str3;
                            obj4 = image;
                            str6 = str13;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        } else {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str14 = str3;
                            obj4 = image;
                            str6 = str14;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                        }
                        int i2110 = i13 & 14;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                        constructor = companion4.getConstructor();
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
                        str8 = str6;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting()) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier4, companion4.getSetModifier());
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        if (obj == null) {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2111 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111 & 896) | 6 | (i2111 & 7168) | (i2111 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i31118 = i24;
                                        ContentScale contentScale1113 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1113, 0.0f, colorFilter5, i31118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1113;
                                        colorFilter4 = colorFilter5;
                                        i25 = i31118;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1114 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1114;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap10 = (Bitmap) obj;
                                                bitmap10.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap10);
                                                obj7 = bitmap10;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i31119 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31119 & 112) | 6 | (i31119 & 896) | (i31119 & 7168) | (i31119 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default10 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default10.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default10);
                                                    obj6 = bitmap$default10;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311110 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311110 & 112) | 6 | (i311110 & 896) | (i311110 & 7168) | (i311110 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default10, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1115 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1115, str9, i24, null, null, composerStartRestartGroup, i311111, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1115;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2112 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2112 & 896) | 6 | (i2112 & 7168) | (i2112 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311112 = i24;
                                        ContentScale contentScale1116 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1116, 0.0f, colorFilter5, i311112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1116;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311112;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1117 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1117;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap11 = (Bitmap) obj;
                                                bitmap11.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap11);
                                                obj7 = bitmap11;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311113 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311113 & 112) | 6 | (i311113 & 896) | (i311113 & 7168) | (i311113 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default11 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default11.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default11);
                                                    obj6 = bitmap$default11;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311114 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311114 & 112) | 6 | (i311114 & 896) | (i311114 & 7168) | (i311114 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default11, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1118 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1118, str9, i24, null, null, composerStartRestartGroup, i311115, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1118;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        } else {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2113 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2113 & 896) | 6 | (i2113 & 7168) | (i2113 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311116 = i24;
                                        ContentScale contentScale1119 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1119, 0.0f, colorFilter5, i311116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1119;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311116;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale11110 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale11110;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap12 = (Bitmap) obj;
                                                bitmap12.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap12);
                                                obj7 = bitmap12;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311117 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311117 & 112) | 6 | (i311117 & 896) | (i311117 & 7168) | (i311117 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default12 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default12.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default12);
                                                    obj6 = bitmap$default12;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311118 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311118 & 112) | 6 | (i311118 & 896) | (i311118 & 7168) | (i311118 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default12 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default12, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale11111 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111, str9, i24, null, null, composerStartRestartGroup, i311119, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale11111;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2114 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2114 & 896) | 6 | (i2114 & 7168) | (i2114 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3111110 = i24;
                                        ContentScale contentScale11112 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11112, 0.0f, colorFilter5, i3111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale11112;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3111110;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale11113 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale11113;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap13 = (Bitmap) obj;
                                                bitmap13.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap13);
                                                obj7 = bitmap13;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3111111 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111 & 112) | 6 | (i3111111 & 896) | (i3111111 & 7168) | (i3111111 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default13 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default13.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default13);
                                                    obj6 = bitmap$default13;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111112 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111112 & 112) | 6 | (i3111112 & 896) | (i3111112 & 7168) | (i3111112 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default13 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default13, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale11114 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11114, str9, i24, null, null, composerStartRestartGroup, i3111113, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale11114;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj3 = obj5;
                        map2 = map5;
                        colorFilter3 = colorFilter4;
                        i23 = i24;
                        str5 = str9;
                        str4 = str7;
                        contentScale3 = contentScale4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj3 = obj2;
                        str4 = str2;
                        colorFilter3 = colorFilter2;
                        contentScale3 = contentScale2;
                        str5 = str3;
                        i23 = i18;
                        map2 = map;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj8, Object obj9) {
                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str15 = str3;
                        obj4 = image;
                        str6 = str15;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str16 = str3;
                        obj4 = image;
                        str6 = str16;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i2115 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier5, companion5.getSetModifier());
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2116 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2116 & 896) | 6 | (i2116 & 7168) | (i2116 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111114 = i24;
                                    ContentScale contentScale11115 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11115, 0.0f, colorFilter5, i3111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11115;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111114;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11116 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11116;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap14 = (Bitmap) obj;
                                            bitmap14.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap14);
                                            obj7 = bitmap14;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111115 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111115 & 112) | 6 | (i3111115 & 896) | (i3111115 & 7168) | (i3111115 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default14 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default14.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default14);
                                                obj6 = bitmap$default14;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111116 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111116 & 112) | 6 | (i3111116 & 896) | (i3111116 & 7168) | (i3111116 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default14 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default14, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11117 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11117, str9, i24, null, null, composerStartRestartGroup, i3111117, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11117;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2117 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2117 & 896) | 6 | (i2117 & 7168) | (i2117 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111118 = i24;
                                    ContentScale contentScale11118 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11118, 0.0f, colorFilter5, i3111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11118;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111118;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11119 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11119;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap15 = (Bitmap) obj;
                                            bitmap15.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap15);
                                            obj7 = bitmap15;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111119 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111119 & 112) | 6 | (i3111119 & 896) | (i3111119 & 7168) | (i3111119 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default15 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default15.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default15);
                                                obj6 = bitmap$default15;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111110 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111110 & 112) | 6 | (i31111110 & 896) | (i31111110 & 7168) | (i31111110 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default15 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default15, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111110 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111110, str9, i24, null, null, composerStartRestartGroup, i31111111, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111110;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2118 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2118 & 896) | 6 | (i2118 & 7168) | (i2118 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111112 = i24;
                                    ContentScale contentScale111111 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111, 0.0f, colorFilter5, i31111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111111;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111112;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111112 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111112;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap16 = (Bitmap) obj;
                                            bitmap16.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap16);
                                            obj7 = bitmap16;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111113 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111113 & 112) | 6 | (i31111113 & 896) | (i31111113 & 7168) | (i31111113 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default16 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default16.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default16);
                                                obj6 = bitmap$default16;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111114 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111114 & 112) | 6 | (i31111114 & 896) | (i31111114 & 7168) | (i31111114 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default16 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default16, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111113 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111113, str9, i24, null, null, composerStartRestartGroup, i31111115, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111113;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2119 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2119 & 896) | 6 | (i2119 & 7168) | (i2119 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111116 = i24;
                                    ContentScale contentScale111114 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111114, 0.0f, colorFilter5, i31111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111114;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111116;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111115 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111115;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap17 = (Bitmap) obj;
                                            bitmap17.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap17);
                                            obj7 = bitmap17;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111117 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111117 & 112) | 6 | (i31111117 & 896) | (i31111117 & 7168) | (i31111117 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default17 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default17.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default17);
                                                obj6 = bitmap$default17;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111118 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111118 & 112) | 6 | (i31111118 & 896) | (i31111118 & 7168) | (i31111118 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default17 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default17, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111116 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111116, str9, i24, null, null, composerStartRestartGroup, i31111119, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111116;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= 24576;
            contentScale2 = contentScale;
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    str3 = str;
                    if (composerStartRestartGroup.changed(str3)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        i18 = i10;
                        if (composerStartRestartGroup.changed(i18)) {
                        }
                        i13 |= i27;
                    } else {
                        i18 = i10;
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i19 = i12 & 128;
                if (i19 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(map)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i13 |= i20;
                }
                i21 = i12 & 256;
                if (i21 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str2)) {
                            i22 = 67108864;
                        } else {
                            i22 = 33554432;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str17 = str3;
                            obj4 = image;
                            str6 = str17;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        } else {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str18 = str3;
                            obj4 = image;
                            str6 = str18;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                        }
                        int i21110 = i13 & 14;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                        ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                        constructor = companion6.getConstructor();
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
                        str8 = str6;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting()) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier6, companion6.getSetModifier());
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        if (obj == null) {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i21111 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111 & 896) | 6 | (i21111 & 7168) | (i21111 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311111110 = i24;
                                        ContentScale contentScale111117 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111117, 0.0f, colorFilter5, i311111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale111117;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311111110;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale111118 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale111118;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap18 = (Bitmap) obj;
                                                bitmap18.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap18);
                                                obj7 = bitmap18;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311111111 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111 & 112) | 6 | (i311111111 & 896) | (i311111111 & 7168) | (i311111111 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default18 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default18.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default18);
                                                    obj6 = bitmap$default18;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311111112 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111112 & 112) | 6 | (i311111112 & 896) | (i311111112 & 7168) | (i311111112 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default18 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default18, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale111119 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111119, str9, i24, null, null, composerStartRestartGroup, i311111113, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale111119;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i21112 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21112 & 896) | 6 | (i21112 & 7168) | (i21112 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311111114 = i24;
                                        ContentScale contentScale1111110 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111110, 0.0f, colorFilter5, i311111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1111110;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311111114;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1111111 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1111111;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap19 = (Bitmap) obj;
                                                bitmap19.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap19);
                                                obj7 = bitmap19;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311111115 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111115 & 112) | 6 | (i311111115 & 896) | (i311111115 & 7168) | (i311111115 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default19 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default19.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default19);
                                                    obj6 = bitmap$default19;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311111116 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111116 & 112) | 6 | (i311111116 & 896) | (i311111116 & 7168) | (i311111116 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default19 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default19, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1111112 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111112, str9, i24, null, null, composerStartRestartGroup, i311111117, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1111112;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        } else {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i21113 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21113 & 896) | 6 | (i21113 & 7168) | (i21113 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311111118 = i24;
                                        ContentScale contentScale1111113 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111113, 0.0f, colorFilter5, i311111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1111113;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311111118;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1111114 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1111114;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap110 = (Bitmap) obj;
                                                bitmap110.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap110);
                                                obj7 = bitmap110;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311111119 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111119 & 112) | 6 | (i311111119 & 896) | (i311111119 & 7168) | (i311111119 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default110 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default110.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default110);
                                                    obj6 = bitmap$default110;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111111110 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111110 & 112) | 6 | (i3111111110 & 896) | (i3111111110 & 7168) | (i3111111110 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default110, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1111115 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111115, str9, i24, null, null, composerStartRestartGroup, i3111111111, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1111115;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i21114 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21114 & 896) | 6 | (i21114 & 7168) | (i21114 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3111111112 = i24;
                                        ContentScale contentScale1111116 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111116, 0.0f, colorFilter5, i3111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale1111116;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3111111112;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale1111117 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale1111117;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap111 = (Bitmap) obj;
                                                bitmap111.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap111);
                                                obj7 = bitmap111;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3111111113 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111113 & 112) | 6 | (i3111111113 & 896) | (i3111111113 & 7168) | (i3111111113 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default111 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default111.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default111);
                                                    obj6 = bitmap$default111;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111111114 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111114 & 112) | 6 | (i3111111114 & 896) | (i3111111114 & 7168) | (i3111111114 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default111, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale1111118 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111118, str9, i24, null, null, composerStartRestartGroup, i3111111115, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale1111118;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj3 = obj5;
                        map2 = map5;
                        colorFilter3 = colorFilter4;
                        i23 = i24;
                        str5 = str9;
                        str4 = str7;
                        contentScale3 = contentScale4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj3 = obj2;
                        str4 = str2;
                        colorFilter3 = colorFilter2;
                        contentScale3 = contentScale2;
                        str5 = str3;
                        i23 = i18;
                        map2 = map;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj8, Object obj9) {
                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str19 = str3;
                        obj4 = image;
                        str6 = str19;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str110 = str3;
                        obj4 = image;
                        str6 = str110;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i21115 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                    ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                    constructor = companion7.getConstructor();
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, companion7.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier7, companion7.getSetModifier());
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21116 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21116 & 896) | 6 | (i21116 & 7168) | (i21116 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111116 = i24;
                                    ContentScale contentScale1111119 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111119, 0.0f, colorFilter5, i3111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111119;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111116;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111110 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111110;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap112 = (Bitmap) obj;
                                            bitmap112.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap112);
                                            obj7 = bitmap112;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111117 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111117 & 112) | 6 | (i3111111117 & 896) | (i3111111117 & 7168) | (i3111111117 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default112 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default112.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default112);
                                                obj6 = bitmap$default112;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111118 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111118 & 112) | 6 | (i3111111118 & 896) | (i3111111118 & 7168) | (i3111111118 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default112, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111, str9, i24, null, null, composerStartRestartGroup, i3111111119, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21117 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21117 & 896) | 6 | (i21117 & 7168) | (i21117 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111110 = i24;
                                    ContentScale contentScale11111112 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111112, 0.0f, colorFilter5, i31111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111112;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111110;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111113 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111113;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap113 = (Bitmap) obj;
                                            bitmap113.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap113);
                                            obj7 = bitmap113;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111111 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111 & 112) | 6 | (i31111111111 & 896) | (i31111111111 & 7168) | (i31111111111 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default113 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default113.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default113);
                                                obj6 = bitmap$default113;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111112 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111112 & 112) | 6 | (i31111111112 & 896) | (i31111111112 & 7168) | (i31111111112 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default113, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111114 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111114, str9, i24, null, null, composerStartRestartGroup, i31111111113, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111114;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21118 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21118 & 896) | 6 | (i21118 & 7168) | (i21118 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111114 = i24;
                                    ContentScale contentScale11111115 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111115, 0.0f, colorFilter5, i31111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111115;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111114;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111116 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111116;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap114 = (Bitmap) obj;
                                            bitmap114.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap114);
                                            obj7 = bitmap114;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111115 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111115 & 112) | 6 | (i31111111115 & 896) | (i31111111115 & 7168) | (i31111111115 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default114 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default114.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default114);
                                                obj6 = bitmap$default114;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111116 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111116 & 112) | 6 | (i31111111116 & 896) | (i31111111116 & 7168) | (i31111111116 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default114, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111117 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111117, str9, i24, null, null, composerStartRestartGroup, i31111111117, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111117;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21119 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21119 & 896) | 6 | (i21119 & 7168) | (i21119 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111118 = i24;
                                    ContentScale contentScale11111118 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111118, 0.0f, colorFilter5, i31111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111118;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111118;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111119 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111119;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap115 = (Bitmap) obj;
                                            bitmap115.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap115);
                                            obj7 = bitmap115;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111119 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111119 & 112) | 6 | (i31111111119 & 896) | (i31111111119 & 7168) | (i31111111119 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default115 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default115.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default115);
                                                obj6 = bitmap$default115;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111110 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111110 & 112) | 6 | (i311111111110 & 896) | (i311111111110 & 7168) | (i311111111110 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default115, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111110 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111110, str9, i24, null, null, composerStartRestartGroup, i311111111111, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111110;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str3 = str;
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i13 |= i27;
            } else {
                i18 = i10;
            }
            i19 = i12 & 128;
            if (i19 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(map)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i13 |= i20;
            }
            i21 = i12 & 256;
            if (i21 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i22 = 67108864;
                    } else {
                        i22 = 33554432;
                    }
                    i13 |= i22;
                }
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str111 = str3;
                        obj4 = image;
                        str6 = str111;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str112 = str3;
                        obj4 = image;
                        str6 = str112;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i211110 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                    ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                    constructor = companion8.getConstructor();
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier8, companion8.getSetModifier());
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211111 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111 & 896) | 6 | (i211111 & 7168) | (i211111 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i311111111112 = i24;
                                    ContentScale contentScale111111111 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111, 0.0f, colorFilter5, i311111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111;
                                    colorFilter4 = colorFilter5;
                                    i25 = i311111111112;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111111112 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111111112;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap116 = (Bitmap) obj;
                                            bitmap116.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap116);
                                            obj7 = bitmap116;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i311111111113 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111113 & 112) | 6 | (i311111111113 & 896) | (i311111111113 & 7168) | (i311111111113 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default116 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default116.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default116);
                                                obj6 = bitmap$default116;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111114 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111114 & 112) | 6 | (i311111111114 & 896) | (i311111111114 & 7168) | (i311111111114 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default116, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111113 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111113, str9, i24, null, null, composerStartRestartGroup, i311111111115, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111113;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211112 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211112 & 896) | 6 | (i211112 & 7168) | (i211112 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i311111111116 = i24;
                                    ContentScale contentScale111111114 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111114, 0.0f, colorFilter5, i311111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111111114;
                                    colorFilter4 = colorFilter5;
                                    i25 = i311111111116;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111111115 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111111115;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap117 = (Bitmap) obj;
                                            bitmap117.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap117);
                                            obj7 = bitmap117;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i311111111117 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111117 & 112) | 6 | (i311111111117 & 896) | (i311111111117 & 7168) | (i311111111117 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default117 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default117.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default117);
                                                obj6 = bitmap$default117;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111118 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111118 & 112) | 6 | (i311111111118 & 896) | (i311111111118 & 7168) | (i311111111118 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default117, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111116 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111116, str9, i24, null, null, composerStartRestartGroup, i311111111119, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111116;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211113 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211113 & 896) | 6 | (i211113 & 7168) | (i211113 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111110 = i24;
                                    ContentScale contentScale111111117 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111117, 0.0f, colorFilter5, i3111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111111117;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111110;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111111118 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111111118;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap118 = (Bitmap) obj;
                                            bitmap118.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap118);
                                            obj7 = bitmap118;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111 & 112) | 6 | (i3111111111111 & 896) | (i3111111111111 & 7168) | (i3111111111111 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default118 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default118.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default118);
                                                obj6 = bitmap$default118;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111112 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111112 & 112) | 6 | (i3111111111112 & 896) | (i3111111111112 & 7168) | (i3111111111112 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default118, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111119 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111119, str9, i24, null, null, composerStartRestartGroup, i3111111111113, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111119;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211114 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211114 & 896) | 6 | (i211114 & 7168) | (i211114 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111114 = i24;
                                    ContentScale contentScale1111111110 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111110, 0.0f, colorFilter5, i3111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111110;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111114;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap119 = (Bitmap) obj;
                                            bitmap119.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap119);
                                            obj7 = bitmap119;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111115 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111115 & 112) | 6 | (i3111111111115 & 896) | (i3111111111115 & 7168) | (i3111111111115 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default119 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default119.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default119);
                                                obj6 = bitmap$default119;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111116 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111116 & 112) | 6 | (i3111111111116 & 896) | (i3111111111116 & 7168) | (i3111111111116 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default119, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111112 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111112, str9, i24, null, null, composerStartRestartGroup, i3111111111117, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111112;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str113 = str3;
                    obj4 = image;
                    str6 = str113;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                } else {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str114 = str3;
                    obj4 = image;
                    str6 = str114;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                }
                int i211115 = i13 & 14;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
                constructor = companion9.getConstructor();
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
                str8 = str6;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier9, companion9.getSetModifier());
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                if (obj == null) {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211116 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211116 & 896) | 6 | (i211116 & 7168) | (i211116 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i3111111111118 = i24;
                                ContentScale contentScale1111111113 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111113, 0.0f, colorFilter5, i3111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111113;
                                colorFilter4 = colorFilter5;
                                i25 = i3111111111118;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111114 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111114;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1110 = (Bitmap) obj;
                                        bitmap1110.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1110);
                                        obj7 = bitmap1110;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i3111111111119 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111119 & 112) | 6 | (i3111111111119 & 896) | (i3111111111119 & 7168) | (i3111111111119 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1110 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1110.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1110);
                                            obj6 = bitmap$default1110;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111110 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111110 & 112) | 6 | (i31111111111110 & 896) | (i31111111111110 & 7168) | (i31111111111110 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1110, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111115 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111115, str9, i24, null, null, composerStartRestartGroup, i31111111111111, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111115;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211117 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211117 & 896) | 6 | (i211117 & 7168) | (i211117 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111112 = i24;
                                ContentScale contentScale1111111116 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111116, 0.0f, colorFilter5, i31111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111116;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111112;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111117 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111117;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1111 = (Bitmap) obj;
                                        bitmap1111.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1111);
                                        obj7 = bitmap1111;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111113 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111113 & 112) | 6 | (i31111111111113 & 896) | (i31111111111113 & 7168) | (i31111111111113 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1111 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1111.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1111);
                                            obj6 = bitmap$default1111;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111114 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111114 & 112) | 6 | (i31111111111114 & 896) | (i31111111111114 & 7168) | (i31111111111114 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1111, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111118 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111118, str9, i24, null, null, composerStartRestartGroup, i31111111111115, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111118;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                } else {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211118 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211118 & 896) | 6 | (i211118 & 7168) | (i211118 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111116 = i24;
                                ContentScale contentScale1111111119 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111119, 0.0f, colorFilter5, i31111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111119;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111116;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale11111111110 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111110;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1112 = (Bitmap) obj;
                                        bitmap1112.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1112);
                                        obj7 = bitmap1112;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111117 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111117 & 112) | 6 | (i31111111111117 & 896) | (i31111111111117 & 7168) | (i31111111111117 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1112 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1112.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1112);
                                            obj6 = bitmap$default1112;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111118 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111118 & 112) | 6 | (i31111111111118 & 896) | (i31111111111118 & 7168) | (i31111111111118 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1112, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale11111111111 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111, str9, i24, null, null, composerStartRestartGroup, i31111111111119, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale11111111111;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211119 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211119 & 896) | 6 | (i211119 & 7168) | (i211119 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i311111111111110 = i24;
                                ContentScale contentScale11111111112 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111112, 0.0f, colorFilter5, i311111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale11111111112;
                                colorFilter4 = colorFilter5;
                                i25 = i311111111111110;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale11111111113 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111113;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1113 = (Bitmap) obj;
                                        bitmap1113.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1113);
                                        obj7 = bitmap1113;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i311111111111111 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111 & 112) | 6 | (i311111111111111 & 896) | (i311111111111111 & 7168) | (i311111111111111 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1113 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1113.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1113);
                                            obj6 = bitmap$default1113;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111112 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111112 & 112) | 6 | (i311111111111112 & 896) | (i311111111111112 & 7168) | (i311111111111112 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1113, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale11111111114 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111114, str9, i24, null, null, composerStartRestartGroup, i311111111111113, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale11111111114;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                map2 = map5;
                colorFilter3 = colorFilter4;
                i23 = i24;
                str5 = str9;
                str4 = str7;
                contentScale3 = contentScale4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                obj3 = obj2;
                str4 = str2;
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str5 = str3;
                i23 = i18;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        colorFilter2 = colorFilter;
        i14 = i12 & 16;
        if (i14 != 0) {
            if ((i11 & 24576) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i13 |= i15;
            }
            i16 = i12 & 32;
            if (i16 != 0) {
                if ((196608 & i11) == 0) {
                    str3 = str;
                    if (composerStartRestartGroup.changed(str3)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i13 |= i17;
                }
                if ((1572864 & i11) == 0) {
                    if ((i12 & 64) == 0) {
                        i18 = i10;
                        if (composerStartRestartGroup.changed(i18)) {
                        }
                        i13 |= i27;
                    } else {
                        i18 = i10;
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i19 = i12 & 128;
                if (i19 != 0) {
                    i13 |= 12582912;
                } else if ((i11 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(map)) {
                        i20 = 8388608;
                    } else {
                        i20 = 4194304;
                    }
                    i13 |= i20;
                }
                i21 = i12 & 256;
                if (i21 != 0) {
                    if ((i11 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str2)) {
                            i22 = 67108864;
                        } else {
                            i22 = 33554432;
                        }
                        i13 |= i22;
                    }
                    if ((i13 & 38347923) != 38347922) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i11 & 1) != 0) {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str115 = str3;
                            obj4 = image;
                            str6 = str115;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        } else {
                            if ((i12 & 4) != 0) {
                                image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                i13 &= -897;
                            } else {
                                image = obj2;
                            }
                            if (i26 != 0) {
                                colorFilter2 = null;
                            }
                            if (i14 != 0) {
                                fit = ContentScale.INSTANCE.getFit();
                            } else {
                                fit = contentScale2;
                            }
                            if (i16 != 0) {
                                str3 = "";
                            }
                            if ((i12 & 64) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i13 &= -3670017;
                            } else {
                                iM5965getHighfv9h1I = i18;
                            }
                            if (i19 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            String str116 = str3;
                            obj4 = image;
                            str6 = str116;
                            contentScale4 = fit;
                            if (i21 != 0) {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = "";
                            } else {
                                i24 = iM5965getHighfv9h1I;
                                map4 = map3;
                                colorFilter4 = colorFilter2;
                                str7 = str2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                        }
                        int i2111110 = i13 & 14;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                        ComposeUiNode.Companion companion10 = ComposeUiNode.INSTANCE;
                        constructor = companion10.getConstructor();
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
                        str8 = str6;
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, companion10.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting()) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier10, companion10.getSetModifier());
                        BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                        if (obj == null) {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2111111 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111 & 896) | 6 | (i2111111 & 7168) | (i2111111 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311111111111114 = i24;
                                        ContentScale contentScale11111111115 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111115, 0.0f, colorFilter5, i311111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111115;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311111111111114;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale11111111116 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale11111111116;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap1114 = (Bitmap) obj;
                                                bitmap1114.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap1114);
                                                obj7 = bitmap1114;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311111111111115 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111115 & 112) | 6 | (i311111111111115 & 896) | (i311111111111115 & 7168) | (i311111111111115 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default1114 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default1114.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default1114);
                                                    obj6 = bitmap$default1114;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i311111111111116 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111116 & 112) | 6 | (i311111111111116 & 896) | (i311111111111116 & 7168) | (i311111111111116 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default1114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default1114, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i311111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale11111111117 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111117, str9, i24, null, null, composerStartRestartGroup, i311111111111117, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale11111111117;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2111112 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111112 & 896) | 6 | (i2111112 & 7168) | (i2111112 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i311111111111118 = i24;
                                        ContentScale contentScale11111111118 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111118, 0.0f, colorFilter5, i311111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111118;
                                        colorFilter4 = colorFilter5;
                                        i25 = i311111111111118;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale11111111119 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale11111111119;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap1115 = (Bitmap) obj;
                                                bitmap1115.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap1115);
                                                obj7 = bitmap1115;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i311111111111119 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111119 & 112) | 6 | (i311111111111119 & 896) | (i311111111111119 & 7168) | (i311111111111119 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default1115 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default1115.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default1115);
                                                    obj6 = bitmap$default1115;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111111111111110 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111110 & 112) | 6 | (i3111111111111110 & 896) | (i3111111111111110 & 7168) | (i3111111111111110 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default1115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default1115, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale111111111110 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111110, str9, i24, null, null, composerStartRestartGroup, i3111111111111111, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale111111111110;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        } else {
                            str9 = str8;
                            if (obj instanceof String) {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2111113 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111113 & 896) | 6 | (i2111113 & 7168) | (i2111113 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3111111111111112 = i24;
                                        ContentScale contentScale111111111111 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111, 0.0f, colorFilter5, i3111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale111111111111;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3111111111111112;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale111111111112 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale111111111112;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap1116 = (Bitmap) obj;
                                                bitmap1116.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap1116);
                                                obj7 = bitmap1116;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3111111111111113 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111113 & 112) | 6 | (i3111111111111113 & 896) | (i3111111111111113 & 7168) | (i3111111111111113 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default1116 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default1116.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default1116);
                                                    obj6 = bitmap$default1116;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111111111111114 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111114 & 112) | 6 | (i3111111111111114 & 896) | (i3111111111111114 & 7168) | (i3111111111111114 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default1116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default1116, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale111111111113 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111113, str9, i24, null, null, composerStartRestartGroup, i3111111111111115, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale111111111113;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            } else {
                                obj5 = obj4;
                                colorFilter5 = colorFilter4;
                                map5 = map4;
                                if (obj instanceof Uri) {
                                    composerStartRestartGroup.startReplaceGroup(1075859374);
                                    int i2111114 = i13 >> 6;
                                    Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111114 & 896) | 6 | (i2111114 & 7168) | (i2111114 & 57344), 32);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorFilter4 = colorFilter5;
                                } else {
                                    if (obj instanceof Integer) {
                                        composerStartRestartGroup.startReplaceGroup(1076190330);
                                        int i3111111111111116 = i24;
                                        ContentScale contentScale111111111114 = contentScale4;
                                        SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111114, 0.0f, colorFilter5, i3111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                        str9 = str9;
                                        contentScale4 = contentScale111111111114;
                                        colorFilter4 = colorFilter5;
                                        i25 = i3111111111111116;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        colorFilter4 = colorFilter5;
                                        i25 = i24;
                                        if (obj instanceof ImageVector) {
                                            composerStartRestartGroup.startReplaceGroup(1076577613);
                                            ContentScale contentScale111111111115 = contentScale4;
                                            androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                            str9 = str9;
                                            contentScale4 = contentScale111111111115;
                                            colorFilter4 = colorFilter4;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Bitmap) {
                                            composerStartRestartGroup.startReplaceGroup(1076916505);
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                obj7 = objRememberedValue3;
                                                Bitmap bitmap1117 = (Bitmap) obj;
                                                bitmap1117.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap1117);
                                                obj7 = bitmap1117;
                                            }
                                            obj7 = objRememberedValue3;
                                            int i3111111111111117 = i13 >> 6;
                                            i24 = i25;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111117 & 112) | 6 | (i3111111111111117 & 896) | (i3111111111111117 & 7168) | (i3111111111111117 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            i24 = i25;
                                            if (obj instanceof Drawable) {
                                                composerStartRestartGroup.startReplaceGroup(1077431663);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    obj6 = objRememberedValue2;
                                                    Bitmap bitmap$default1117 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                    bitmap$default1117.prepareToDraw();
                                                    composerStartRestartGroup.updateRememberedValue(bitmap$default1117);
                                                    obj6 = bitmap$default1117;
                                                }
                                                obj6 = objRememberedValue2;
                                                int i3111111111111118 = i13 >> 6;
                                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111118 & 112) | 6 | (i3111111111111118 & 896) | (i3111111111111118 & 7168) | (i3111111111111118 & 57344), 64);
                                                str9 = str9;
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else if (obj instanceof Color) {
                                                composerStartRestartGroup.startReplaceGroup(1077974876);
                                                Modifier modifierFillMaxSize$default1117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance) {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                } else {
                                                    objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj8) {
                                                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                CanvasKt.Canvas(modifierFillMaxSize$default1117, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(1078222008);
                                                int i3111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                                ContentScale contentScale111111111116 = contentScale4;
                                                m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111116, str9, i24, null, null, composerStartRestartGroup, i3111111111111119, 388);
                                                colorFilter4 = colorFilter4;
                                                contentScale4 = contentScale111111111116;
                                                i24 = i24;
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                        }
                                    }
                                    i24 = i25;
                                }
                            }
                        }
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj3 = obj5;
                        map2 = map5;
                        colorFilter3 = colorFilter4;
                        i23 = i24;
                        str5 = str9;
                        str4 = str7;
                        contentScale3 = contentScale4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj3 = obj2;
                        str4 = str2;
                        colorFilter3 = colorFilter2;
                        contentScale3 = contentScale2;
                        str5 = str3;
                        i23 = i18;
                        map2 = map;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj8, Object obj9) {
                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                            }
                        });
                    }
                }
                i13 |= 100663296;
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str117 = str3;
                        obj4 = image;
                        str6 = str117;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str118 = str3;
                        obj4 = image;
                        str6 = str118;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i2111115 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                    ComposeUiNode.Companion companion11 = ComposeUiNode.INSTANCE;
                    constructor = companion11.getConstructor();
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier11, companion11.getSetModifier());
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2111116 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111116 & 896) | 6 | (i2111116 & 7168) | (i2111116 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111111111110 = i24;
                                    ContentScale contentScale111111111117 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111117, 0.0f, colorFilter5, i31111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111117;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111111111110;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale111111111118 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale111111111118;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap1118 = (Bitmap) obj;
                                            bitmap1118.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap1118);
                                            obj7 = bitmap1118;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111111111111 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111 & 112) | 6 | (i31111111111111111 & 896) | (i31111111111111111 & 7168) | (i31111111111111111 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default1118 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default1118.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default1118);
                                                obj6 = bitmap$default1118;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111111111112 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111112 & 112) | 6 | (i31111111111111112 & 896) | (i31111111111111112 & 7168) | (i31111111111111112 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default1118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default1118, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111111119 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111119, str9, i24, null, null, composerStartRestartGroup, i31111111111111113, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111111119;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2111117 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111117 & 896) | 6 | (i2111117 & 7168) | (i2111117 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111111111114 = i24;
                                    ContentScale contentScale1111111111110 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111110, 0.0f, colorFilter5, i31111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111110;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111111111114;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111111 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111111;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap1119 = (Bitmap) obj;
                                            bitmap1119.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap1119);
                                            obj7 = bitmap1119;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111111111115 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111115 & 112) | 6 | (i31111111111111115 & 896) | (i31111111111111115 & 7168) | (i31111111111111115 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default1119 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default1119.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default1119);
                                                obj6 = bitmap$default1119;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111111111116 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111116 & 112) | 6 | (i31111111111111116 & 896) | (i31111111111111116 & 7168) | (i31111111111111116 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default1119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default1119, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111111112 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111112, str9, i24, null, null, composerStartRestartGroup, i31111111111111117, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111111112;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2111118 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111118 & 896) | 6 | (i2111118 & 7168) | (i2111118 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111111111118 = i24;
                                    ContentScale contentScale1111111111113 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111113, 0.0f, colorFilter5, i31111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111113;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111111111118;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111114 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111114;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11110 = (Bitmap) obj;
                                            bitmap11110.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11110);
                                            obj7 = bitmap11110;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111111111119 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111119 & 112) | 6 | (i31111111111111119 & 896) | (i31111111111111119 & 7168) | (i31111111111111119 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11110 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11110.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11110);
                                                obj6 = bitmap$default11110;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111111111110 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111110 & 112) | 6 | (i311111111111111110 & 896) | (i311111111111111110 & 7168) | (i311111111111111110 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11110, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111111115 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111115, str9, i24, null, null, composerStartRestartGroup, i311111111111111111, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111111115;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i2111119 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111119 & 896) | 6 | (i2111119 & 7168) | (i2111119 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i311111111111111112 = i24;
                                    ContentScale contentScale1111111111116 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111116, 0.0f, colorFilter5, i311111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111116;
                                    colorFilter4 = colorFilter5;
                                    i25 = i311111111111111112;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111117 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111117;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11111 = (Bitmap) obj;
                                            bitmap11111.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11111);
                                            obj7 = bitmap11111;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i311111111111111113 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111113 & 112) | 6 | (i311111111111111113 & 896) | (i311111111111111113 & 7168) | (i311111111111111113 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11111 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11111.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11111);
                                                obj6 = bitmap$default11111;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111111111114 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111114 & 112) | 6 | (i311111111111111114 & 896) | (i311111111111111114 & 7168) | (i311111111111111114 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11111, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111111118 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111118, str9, i24, null, null, composerStartRestartGroup, i311111111111111115, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111111118;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str3 = str;
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i13 |= i27;
            } else {
                i18 = i10;
            }
            i19 = i12 & 128;
            if (i19 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(map)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i13 |= i20;
            }
            i21 = i12 & 256;
            if (i21 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i22 = 67108864;
                    } else {
                        i22 = 33554432;
                    }
                    i13 |= i22;
                }
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str119 = str3;
                        obj4 = image;
                        str6 = str119;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str1110 = str3;
                        obj4 = image;
                        str6 = str1110;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i21111110 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                    ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                    constructor = companion12.getConstructor();
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier12, companion12.getSetModifier());
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21111111 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111111 & 896) | 6 | (i21111111 & 7168) | (i21111111 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i311111111111111116 = i24;
                                    ContentScale contentScale1111111111119 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111119, 0.0f, colorFilter5, i311111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111119;
                                    colorFilter4 = colorFilter5;
                                    i25 = i311111111111111116;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111110 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111110;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11112 = (Bitmap) obj;
                                            bitmap11112.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11112);
                                            obj7 = bitmap11112;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i311111111111111117 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111117 & 112) | 6 | (i311111111111111117 & 896) | (i311111111111111117 & 7168) | (i311111111111111117 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11112 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11112.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11112);
                                                obj6 = bitmap$default11112;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i311111111111111118 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111118 & 112) | 6 | (i311111111111111118 & 896) | (i311111111111111118 & 7168) | (i311111111111111118 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11112, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i311111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111111111 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111, str9, i24, null, null, composerStartRestartGroup, i311111111111111119, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111111111;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21111112 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111112 & 896) | 6 | (i21111112 & 7168) | (i21111112 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111111111110 = i24;
                                    ContentScale contentScale11111111111112 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111112, 0.0f, colorFilter5, i3111111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111112;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111111111110;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111113 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111113;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11113 = (Bitmap) obj;
                                            bitmap11113.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11113);
                                            obj7 = bitmap11113;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111111111 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111 & 112) | 6 | (i3111111111111111111 & 896) | (i3111111111111111111 & 7168) | (i3111111111111111111 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11113 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11113.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11113);
                                                obj6 = bitmap$default11113;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111111111112 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111112 & 112) | 6 | (i3111111111111111112 & 896) | (i3111111111111111112 & 7168) | (i3111111111111111112 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11113, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111111114 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111114, str9, i24, null, null, composerStartRestartGroup, i3111111111111111113, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111111114;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21111113 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111113 & 896) | 6 | (i21111113 & 7168) | (i21111113 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111111111114 = i24;
                                    ContentScale contentScale11111111111115 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111115, 0.0f, colorFilter5, i3111111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111115;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111111111114;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111116 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111116;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11114 = (Bitmap) obj;
                                            bitmap11114.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11114);
                                            obj7 = bitmap11114;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111111115 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111115 & 112) | 6 | (i3111111111111111115 & 896) | (i3111111111111111115 & 7168) | (i3111111111111111115 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11114 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11114.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11114);
                                                obj6 = bitmap$default11114;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111111111116 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111116 & 112) | 6 | (i3111111111111111116 & 896) | (i3111111111111111116 & 7168) | (i3111111111111111116 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11114, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111111117 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111117, str9, i24, null, null, composerStartRestartGroup, i3111111111111111117, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111111117;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i21111114 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111114 & 896) | 6 | (i21111114 & 7168) | (i21111114 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111111111118 = i24;
                                    ContentScale contentScale11111111111118 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111118, 0.0f, colorFilter5, i3111111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111118;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111111111118;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111119 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111119;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap11115 = (Bitmap) obj;
                                            bitmap11115.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap11115);
                                            obj7 = bitmap11115;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111111119 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111119 & 112) | 6 | (i3111111111111111119 & 896) | (i3111111111111111119 & 7168) | (i3111111111111111119 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default11115 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default11115.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default11115);
                                                obj6 = bitmap$default11115;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111111111111110 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111110 & 112) | 6 | (i31111111111111111110 & 896) | (i31111111111111111110 & 7168) | (i31111111111111111110 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default11115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default11115, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale111111111111110 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111110, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale111111111111110;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1111 = str3;
                    obj4 = image;
                    str6 = str1111;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                } else {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1112 = str3;
                    obj4 = image;
                    str6 = str1112;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                }
                int i21111115 = i13 & 14;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion13 = ComposeUiNode.INSTANCE;
                constructor = companion13.getConstructor();
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
                str8 = str6;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, companion13.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion13.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier13, companion13.getSetModifier());
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                if (obj == null) {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i21111116 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111116 & 896) | 6 | (i21111116 & 7168) | (i21111116 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111111111112 = i24;
                                ContentScale contentScale111111111111111 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111111, 0.0f, colorFilter5, i31111111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111111;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111111111112;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111112 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111112;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap11116 = (Bitmap) obj;
                                        bitmap11116.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap11116);
                                        obj7 = bitmap11116;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111111111113 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111113 & 112) | 6 | (i31111111111111111113 & 896) | (i31111111111111111113 & 7168) | (i31111111111111111113 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default11116 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default11116.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default11116);
                                            obj6 = bitmap$default11116;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111111111114 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111114 & 112) | 6 | (i31111111111111111114 & 896) | (i31111111111111111114 & 7168) | (i31111111111111111114 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default11116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default11116, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111113 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111113, str9, i24, null, null, composerStartRestartGroup, i31111111111111111115, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111113;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i21111117 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111117 & 896) | 6 | (i21111117 & 7168) | (i21111117 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111111111116 = i24;
                                ContentScale contentScale111111111111114 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111114, 0.0f, colorFilter5, i31111111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111114;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111111111116;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111115 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111115;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap11117 = (Bitmap) obj;
                                        bitmap11117.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap11117);
                                        obj7 = bitmap11117;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111111111117 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111117 & 112) | 6 | (i31111111111111111117 & 896) | (i31111111111111111117 & 7168) | (i31111111111111111117 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default11117 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default11117.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default11117);
                                            obj6 = bitmap$default11117;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111111111118 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111118 & 112) | 6 | (i31111111111111111118 & 896) | (i31111111111111111118 & 7168) | (i31111111111111111118 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default11117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default11117, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111116 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111116, str9, i24, null, null, composerStartRestartGroup, i31111111111111111119, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111116;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                } else {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i21111118 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111118 & 896) | 6 | (i21111118 & 7168) | (i21111118 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i311111111111111111110 = i24;
                                ContentScale contentScale111111111111117 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111117, 0.0f, colorFilter5, i311111111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111117;
                                colorFilter4 = colorFilter5;
                                i25 = i311111111111111111110;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111118 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111118;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap11118 = (Bitmap) obj;
                                        bitmap11118.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap11118);
                                        obj7 = bitmap11118;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i311111111111111111111 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111 & 112) | 6 | (i311111111111111111111 & 896) | (i311111111111111111111 & 7168) | (i311111111111111111111 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default11118 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default11118.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default11118);
                                            obj6 = bitmap$default11118;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111111111112 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111112 & 112) | 6 | (i311111111111111111112 & 896) | (i311111111111111111112 & 7168) | (i311111111111111111112 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default11118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default11118, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111119 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111119, str9, i24, null, null, composerStartRestartGroup, i311111111111111111113, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111119;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i21111119 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i21111119 & 896) | 6 | (i21111119 & 7168) | (i21111119 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i311111111111111111114 = i24;
                                ContentScale contentScale1111111111111110 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111110, 0.0f, colorFilter5, i311111111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111111111110;
                                colorFilter4 = colorFilter5;
                                i25 = i311111111111111111114;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111111111111 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111111;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap11119 = (Bitmap) obj;
                                        bitmap11119.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap11119);
                                        obj7 = bitmap11119;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i311111111111111111115 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111115 & 112) | 6 | (i311111111111111111115 & 896) | (i311111111111111111115 & 7168) | (i311111111111111111115 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default11119 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default11119.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default11119);
                                            obj6 = bitmap$default11119;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111111111116 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111116 & 112) | 6 | (i311111111111111111116 & 896) | (i311111111111111111116 & 7168) | (i311111111111111111116 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default11119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default11119, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111111111112 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111112, str9, i24, null, null, composerStartRestartGroup, i311111111111111111117, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111111111112;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                map2 = map5;
                colorFilter3 = colorFilter4;
                i23 = i24;
                str5 = str9;
                str4 = str7;
                contentScale3 = contentScale4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                obj3 = obj2;
                str4 = str2;
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str5 = str3;
                i23 = i18;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                });
            }
        }
        i13 |= 24576;
        contentScale2 = contentScale;
        i16 = i12 & 32;
        if (i16 != 0) {
            if ((196608 & i11) == 0) {
                str3 = str;
                if (composerStartRestartGroup.changed(str3)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i13 |= i17;
            }
            if ((1572864 & i11) == 0) {
                if ((i12 & 64) == 0) {
                    i18 = i10;
                    if (composerStartRestartGroup.changed(i18)) {
                    }
                    i13 |= i27;
                } else {
                    i18 = i10;
                }
                i13 |= i27;
            } else {
                i18 = i10;
            }
            i19 = i12 & 128;
            if (i19 != 0) {
                i13 |= 12582912;
            } else if ((i11 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(map)) {
                    i20 = 8388608;
                } else {
                    i20 = 4194304;
                }
                i13 |= i20;
            }
            i21 = i12 & 256;
            if (i21 != 0) {
                if ((i11 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i22 = 67108864;
                    } else {
                        i22 = 33554432;
                    }
                    i13 |= i22;
                }
                if ((i13 & 38347923) != 38347922) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i11 & 1) != 0) {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str1113 = str3;
                        obj4 = image;
                        str6 = str1113;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    } else {
                        if ((i12 & 4) != 0) {
                            image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                            i13 &= -897;
                        } else {
                            image = obj2;
                        }
                        if (i26 != 0) {
                            colorFilter2 = null;
                        }
                        if (i14 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i16 != 0) {
                            str3 = "";
                        }
                        if ((i12 & 64) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i13 &= -3670017;
                        } else {
                            iM5965getHighfv9h1I = i18;
                        }
                        if (i19 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        String str1114 = str3;
                        obj4 = image;
                        str6 = str1114;
                        contentScale4 = fit;
                        if (i21 != 0) {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = "";
                        } else {
                            i24 = iM5965getHighfv9h1I;
                            map4 = map3;
                            colorFilter4 = colorFilter2;
                            str7 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                    }
                    int i211111110 = i13 & 14;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                    ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
                    constructor = companion14.getConstructor();
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
                    str8 = str6;
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion14.getSetCompositeKeyHash();
                    if (composerM5176constructorimpl.getInserting()) {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier14, companion14.getSetModifier());
                    BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                    if (obj == null) {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211111111 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111111 & 896) | 6 | (i211111111 & 7168) | (i211111111 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i311111111111111111118 = i24;
                                    ContentScale contentScale1111111111111113 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111113, 0.0f, colorFilter5, i311111111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111113;
                                    colorFilter4 = colorFilter5;
                                    i25 = i311111111111111111118;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111111114 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111111114;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap111110 = (Bitmap) obj;
                                            bitmap111110.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap111110);
                                            obj7 = bitmap111110;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i311111111111111111119 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111119 & 112) | 6 | (i311111111111111111119 & 896) | (i311111111111111111119 & 7168) | (i311111111111111111119 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default111110 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default111110.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default111110);
                                                obj6 = bitmap$default111110;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111111111111110 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111110 & 112) | 6 | (i3111111111111111111110 & 896) | (i3111111111111111111110 & 7168) | (i3111111111111111111110 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default111110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default111110, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111111111115 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111115, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111111, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111111111115;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211111112 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111112 & 896) | 6 | (i211111112 & 7168) | (i211111112 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111111111111112 = i24;
                                    ContentScale contentScale1111111111111116 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111116, 0.0f, colorFilter5, i3111111111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111116;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111111111111112;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale1111111111111117 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale1111111111111117;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap111111 = (Bitmap) obj;
                                            bitmap111111.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap111111);
                                            obj7 = bitmap111111;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111111111113 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111113 & 112) | 6 | (i3111111111111111111113 & 896) | (i3111111111111111111113 & 7168) | (i3111111111111111111113 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default111111 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default111111.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default111111);
                                                obj6 = bitmap$default111111;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111111111111114 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111114 & 112) | 6 | (i3111111111111111111114 & 896) | (i3111111111111111111114 & 7168) | (i3111111111111111111114 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default111111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default111111, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale1111111111111118 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111118, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111115, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale1111111111111118;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    } else {
                        str9 = str8;
                        if (obj instanceof String) {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211111113 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111113 & 896) | 6 | (i211111113 & 7168) | (i211111113 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i3111111111111111111116 = i24;
                                    ContentScale contentScale1111111111111119 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111119, 0.0f, colorFilter5, i3111111111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111119;
                                    colorFilter4 = colorFilter5;
                                    i25 = i3111111111111111111116;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111111110 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111111110;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap111112 = (Bitmap) obj;
                                            bitmap111112.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap111112);
                                            obj7 = bitmap111112;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i3111111111111111111117 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111117 & 112) | 6 | (i3111111111111111111117 & 896) | (i3111111111111111111117 & 7168) | (i3111111111111111111117 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default111112 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default111112.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default111112);
                                                obj6 = bitmap$default111112;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i3111111111111111111118 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111118 & 112) | 6 | (i3111111111111111111118 & 896) | (i3111111111111111111118 & 7168) | (i3111111111111111111118 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default111112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default111112, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i3111111111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111111111111 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111111, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111119, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111111111111;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        } else {
                            obj5 = obj4;
                            colorFilter5 = colorFilter4;
                            map5 = map4;
                            if (obj instanceof Uri) {
                                composerStartRestartGroup.startReplaceGroup(1075859374);
                                int i211111114 = i13 >> 6;
                                Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111114 & 896) | 6 | (i211111114 & 7168) | (i211111114 & 57344), 32);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                                colorFilter4 = colorFilter5;
                            } else {
                                if (obj instanceof Integer) {
                                    composerStartRestartGroup.startReplaceGroup(1076190330);
                                    int i31111111111111111111110 = i24;
                                    ContentScale contentScale11111111111111112 = contentScale4;
                                    SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111112, 0.0f, colorFilter5, i31111111111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111111112;
                                    colorFilter4 = colorFilter5;
                                    i25 = i31111111111111111111110;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    colorFilter4 = colorFilter5;
                                    i25 = i24;
                                    if (obj instanceof ImageVector) {
                                        composerStartRestartGroup.startReplaceGroup(1076577613);
                                        ContentScale contentScale11111111111111113 = contentScale4;
                                        androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                        str9 = str9;
                                        contentScale4 = contentScale11111111111111113;
                                        colorFilter4 = colorFilter4;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Bitmap) {
                                        composerStartRestartGroup.startReplaceGroup(1076916505);
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            obj7 = objRememberedValue3;
                                            Bitmap bitmap111113 = (Bitmap) obj;
                                            bitmap111113.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap111113);
                                            obj7 = bitmap111113;
                                        }
                                        obj7 = objRememberedValue3;
                                        int i31111111111111111111111 = i13 >> 6;
                                        i24 = i25;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111111111 & 112) | 6 | (i31111111111111111111111 & 896) | (i31111111111111111111111 & 7168) | (i31111111111111111111111 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        i24 = i25;
                                        if (obj instanceof Drawable) {
                                            composerStartRestartGroup.startReplaceGroup(1077431663);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                obj6 = objRememberedValue2;
                                                Bitmap bitmap$default111113 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                                bitmap$default111113.prepareToDraw();
                                                composerStartRestartGroup.updateRememberedValue(bitmap$default111113);
                                                obj6 = bitmap$default111113;
                                            }
                                            obj6 = objRememberedValue2;
                                            int i31111111111111111111112 = i13 >> 6;
                                            Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111111112 & 112) | 6 | (i31111111111111111111112 & 896) | (i31111111111111111111112 & 7168) | (i31111111111111111111112 & 57344), 64);
                                            str9 = str9;
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else if (obj instanceof Color) {
                                            composerStartRestartGroup.startReplaceGroup(1077974876);
                                            Modifier modifierFillMaxSize$default111113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            } else {
                                                objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj8) {
                                                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            CanvasKt.Canvas(modifierFillMaxSize$default111113, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                            composerStartRestartGroup.endReplaceGroup();
                                        } else {
                                            composerStartRestartGroup.startReplaceGroup(1078222008);
                                            int i31111111111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                            ContentScale contentScale11111111111111114 = contentScale4;
                                            m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111114, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111113, 388);
                                            colorFilter4 = colorFilter4;
                                            contentScale4 = contentScale11111111111111114;
                                            i24 = i24;
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                    }
                                }
                                i24 = i25;
                            }
                        }
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = obj5;
                    map2 = map5;
                    colorFilter3 = colorFilter4;
                    i23 = i24;
                    str5 = str9;
                    str4 = str7;
                    contentScale3 = contentScale4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    obj3 = obj2;
                    str4 = str2;
                    colorFilter3 = colorFilter2;
                    contentScale3 = contentScale2;
                    str5 = str3;
                    i23 = i18;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                }
            }
            i13 |= 100663296;
            if ((i13 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1115 = str3;
                    obj4 = image;
                    str6 = str1115;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                } else {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1116 = str3;
                    obj4 = image;
                    str6 = str1116;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                }
                int i211111115 = i13 & 14;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion15 = ComposeUiNode.INSTANCE;
                constructor = companion15.getConstructor();
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
                str8 = str6;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion15.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier15, companion15.getSetModifier());
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                if (obj == null) {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211111116 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111116 & 896) | 6 | (i211111116 & 7168) | (i211111116 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111111111111114 = i24;
                                ContentScale contentScale11111111111111115 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111115, 0.0f, colorFilter5, i31111111111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111115;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111111111111114;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale11111111111111116 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111111116;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111114 = (Bitmap) obj;
                                        bitmap111114.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111114);
                                        obj7 = bitmap111114;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111111111111115 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111111115 & 112) | 6 | (i31111111111111111111115 & 896) | (i31111111111111111111115 & 7168) | (i31111111111111111111115 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111114 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111114.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111114);
                                            obj6 = bitmap$default111114;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111111111111116 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111111116 & 112) | 6 | (i31111111111111111111116 & 896) | (i31111111111111111111116 & 7168) | (i31111111111111111111116 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111114, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale11111111111111117 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111117, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111117, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale11111111111111117;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211111117 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111117 & 896) | 6 | (i211111117 & 7168) | (i211111117 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111111111111118 = i24;
                                ContentScale contentScale11111111111111118 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111118, 0.0f, colorFilter5, i31111111111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111118;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111111111111118;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale11111111111111119 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale11111111111111119;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111115 = (Bitmap) obj;
                                        bitmap111115.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111115);
                                        obj7 = bitmap111115;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111111111111119 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111111119 & 112) | 6 | (i31111111111111111111119 & 896) | (i31111111111111111111119 & 7168) | (i31111111111111111111119 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111115 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111115.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111115);
                                            obj6 = bitmap$default111115;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111111111111110 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111111110 & 112) | 6 | (i311111111111111111111110 & 896) | (i311111111111111111111110 & 7168) | (i311111111111111111111110 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111115, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111111110 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111111110, str9, i24, null, null, composerStartRestartGroup, i311111111111111111111111, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111111110;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                } else {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211111118 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111118 & 896) | 6 | (i211111118 & 7168) | (i211111118 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i311111111111111111111112 = i24;
                                ContentScale contentScale111111111111111111 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111111111, 0.0f, colorFilter5, i311111111111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111111111;
                                colorFilter4 = colorFilter5;
                                i25 = i311111111111111111111112;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111111112 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111111112, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111111112;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111116 = (Bitmap) obj;
                                        bitmap111116.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111116);
                                        obj7 = bitmap111116;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i311111111111111111111113 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111113 & 112) | 6 | (i311111111111111111111113 & 896) | (i311111111111111111111113 & 7168) | (i311111111111111111111113 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111116 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111116.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111116);
                                            obj6 = bitmap$default111116;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111111111111114 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111111114 & 112) | 6 | (i311111111111111111111114 & 896) | (i311111111111111111111114 & 7168) | (i311111111111111111111114 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111116, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111111113 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111111113, str9, i24, null, null, composerStartRestartGroup, i311111111111111111111115, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111111113;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i211111119 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i211111119 & 896) | 6 | (i211111119 & 7168) | (i211111119 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i311111111111111111111116 = i24;
                                ContentScale contentScale111111111111111114 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111111114, 0.0f, colorFilter5, i311111111111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111111114;
                                colorFilter4 = colorFilter5;
                                i25 = i311111111111111111111116;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111111115 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111111115, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111111115;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111117 = (Bitmap) obj;
                                        bitmap111117.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111117);
                                        obj7 = bitmap111117;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i311111111111111111111117 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111117 & 112) | 6 | (i311111111111111111111117 & 896) | (i311111111111111111111117 & 7168) | (i311111111111111111111117 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111117 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111117.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111117);
                                            obj6 = bitmap$default111117;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i311111111111111111111118 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111111118 & 112) | 6 | (i311111111111111111111118 & 896) | (i311111111111111111111118 & 7168) | (i311111111111111111111118 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111117, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i311111111111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111111116 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111111116, str9, i24, null, null, composerStartRestartGroup, i311111111111111111111119, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111111116;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                map2 = map5;
                colorFilter3 = colorFilter4;
                i23 = i24;
                str5 = str9;
                str4 = str7;
                contentScale3 = contentScale4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                obj3 = obj2;
                str4 = str2;
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str5 = str3;
                i23 = i18;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                });
            }
        }
        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str3 = str;
        if ((1572864 & i11) == 0) {
            if ((i12 & 64) == 0) {
                i18 = i10;
                if (composerStartRestartGroup.changed(i18)) {
                }
                i13 |= i27;
            } else {
                i18 = i10;
            }
            i13 |= i27;
        } else {
            i18 = i10;
        }
        i19 = i12 & 128;
        if (i19 != 0) {
            i13 |= 12582912;
        } else if ((i11 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(map)) {
                i20 = 8388608;
            } else {
                i20 = 4194304;
            }
            i13 |= i20;
        }
        i21 = i12 & 256;
        if (i21 != 0) {
            if ((i11 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i22 = 67108864;
                } else {
                    i22 = 33554432;
                }
                i13 |= i22;
            }
            if ((i13 & 38347923) != 38347922) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i11 & 1) != 0) {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1117 = str3;
                    obj4 = image;
                    str6 = str1117;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                } else {
                    if ((i12 & 4) != 0) {
                        image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                        i13 &= -897;
                    } else {
                        image = obj2;
                    }
                    if (i26 != 0) {
                        colorFilter2 = null;
                    }
                    if (i14 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i16 != 0) {
                        str3 = "";
                    }
                    if ((i12 & 64) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i13 &= -3670017;
                    } else {
                        iM5965getHighfv9h1I = i18;
                    }
                    if (i19 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    String str1118 = str3;
                    obj4 = image;
                    str6 = str1118;
                    contentScale4 = fit;
                    if (i21 != 0) {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = "";
                    } else {
                        i24 = iM5965getHighfv9h1I;
                        map4 = map3;
                        colorFilter4 = colorFilter2;
                        str7 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
                }
                int i2111111110 = i13 & 14;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
                ComposeUiNode.Companion companion16 = ComposeUiNode.INSTANCE;
                constructor = companion16.getConstructor();
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
                str8 = str6;
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy16, companion16.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap16, companion16.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion16.getSetCompositeKeyHash();
                if (composerM5176constructorimpl.getInserting()) {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier16, companion16.getSetModifier());
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                if (obj == null) {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i2111111111 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111111 & 896) | 6 | (i2111111111 & 7168) | (i2111111111 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i3111111111111111111111110 = i24;
                                ContentScale contentScale111111111111111117 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale111111111111111117, 0.0f, colorFilter5, i3111111111111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale111111111111111117;
                                colorFilter4 = colorFilter5;
                                i25 = i3111111111111111111111110;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale111111111111111118 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale111111111111111118, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale111111111111111118;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111118 = (Bitmap) obj;
                                        bitmap111118.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111118);
                                        obj7 = bitmap111118;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i3111111111111111111111111 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111111111 & 112) | 6 | (i3111111111111111111111111 & 896) | (i3111111111111111111111111 & 7168) | (i3111111111111111111111111 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111118 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111118.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111118);
                                            obj6 = bitmap$default111118;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i3111111111111111111111112 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111111112 & 112) | 6 | (i3111111111111111111111112 & 896) | (i3111111111111111111111112 & 7168) | (i3111111111111111111111112 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111118, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i3111111111111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale111111111111111119 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111111119, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111111113, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale111111111111111119;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i2111111112 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111112 & 896) | 6 | (i2111111112 & 7168) | (i2111111112 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i3111111111111111111111114 = i24;
                                ContentScale contentScale1111111111111111110 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111111110, 0.0f, colorFilter5, i3111111111111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111111111111110;
                                colorFilter4 = colorFilter5;
                                i25 = i3111111111111111111111114;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111111111111111 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111111111, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111111111;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap111119 = (Bitmap) obj;
                                        bitmap111119.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap111119);
                                        obj7 = bitmap111119;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i3111111111111111111111115 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111111115 & 112) | 6 | (i3111111111111111111111115 & 896) | (i3111111111111111111111115 & 7168) | (i3111111111111111111111115 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default111119 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default111119.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default111119);
                                            obj6 = bitmap$default111119;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i3111111111111111111111116 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111111116 & 112) | 6 | (i3111111111111111111111116 & 896) | (i3111111111111111111111116 & 7168) | (i3111111111111111111111116 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default111119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default111119, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i3111111111111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111111111111112 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111111112, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111111117, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111111111111112;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                } else {
                    str9 = str8;
                    if (obj instanceof String) {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i2111111113 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111113 & 896) | 6 | (i2111111113 & 7168) | (i2111111113 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i3111111111111111111111118 = i24;
                                ContentScale contentScale1111111111111111113 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111111113, 0.0f, colorFilter5, i3111111111111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111111111111113;
                                colorFilter4 = colorFilter5;
                                i25 = i3111111111111111111111118;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111111111111114 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111111114, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111111114;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1111110 = (Bitmap) obj;
                                        bitmap1111110.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1111110);
                                        obj7 = bitmap1111110;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i3111111111111111111111119 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i3111111111111111111111119 & 112) | 6 | (i3111111111111111111111119 & 896) | (i3111111111111111111111119 & 7168) | (i3111111111111111111111119 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1111110 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1111110.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1111110);
                                            obj6 = bitmap$default1111110;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111111111111111110 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111111111110 & 112) | 6 | (i31111111111111111111111110 & 896) | (i31111111111111111111111110 & 7168) | (i31111111111111111111111110 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1111110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1111110, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111111111111115 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111111115, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111111111, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111111111111115;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    } else {
                        obj5 = obj4;
                        colorFilter5 = colorFilter4;
                        map5 = map4;
                        if (obj instanceof Uri) {
                            composerStartRestartGroup.startReplaceGroup(1075859374);
                            int i2111111114 = i13 >> 6;
                            Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111114 & 896) | 6 | (i2111111114 & 7168) | (i2111111114 & 57344), 32);
                            str9 = str9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorFilter4 = colorFilter5;
                        } else {
                            if (obj instanceof Integer) {
                                composerStartRestartGroup.startReplaceGroup(1076190330);
                                int i31111111111111111111111112 = i24;
                                ContentScale contentScale1111111111111111116 = contentScale4;
                                SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111111116, 0.0f, colorFilter5, i31111111111111111111111112, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                                str9 = str9;
                                contentScale4 = contentScale1111111111111111116;
                                colorFilter4 = colorFilter5;
                                i25 = i31111111111111111111111112;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                colorFilter4 = colorFilter5;
                                i25 = i24;
                                if (obj instanceof ImageVector) {
                                    composerStartRestartGroup.startReplaceGroup(1076577613);
                                    ContentScale contentScale1111111111111111117 = contentScale4;
                                    androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale1111111111111111117, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                    str9 = str9;
                                    contentScale4 = contentScale1111111111111111117;
                                    colorFilter4 = colorFilter4;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Bitmap) {
                                    composerStartRestartGroup.startReplaceGroup(1076916505);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        obj7 = objRememberedValue3;
                                        Bitmap bitmap1111111 = (Bitmap) obj;
                                        bitmap1111111.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap1111111);
                                        obj7 = bitmap1111111;
                                    }
                                    obj7 = objRememberedValue3;
                                    int i31111111111111111111111113 = i13 >> 6;
                                    i24 = i25;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111111111113 & 112) | 6 | (i31111111111111111111111113 & 896) | (i31111111111111111111111113 & 7168) | (i31111111111111111111111113 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    i24 = i25;
                                    if (obj instanceof Drawable) {
                                        composerStartRestartGroup.startReplaceGroup(1077431663);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            obj6 = objRememberedValue2;
                                            Bitmap bitmap$default1111111 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                            bitmap$default1111111.prepareToDraw();
                                            composerStartRestartGroup.updateRememberedValue(bitmap$default1111111);
                                            obj6 = bitmap$default1111111;
                                        }
                                        obj6 = objRememberedValue2;
                                        int i31111111111111111111111114 = i13 >> 6;
                                        Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111111111114 & 112) | 6 | (i31111111111111111111111114 & 896) | (i31111111111111111111111114 & 7168) | (i31111111111111111111111114 & 57344), 64);
                                        str9 = str9;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else if (obj instanceof Color) {
                                        composerStartRestartGroup.startReplaceGroup(1077974876);
                                        Modifier modifierFillMaxSize$default1111111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        } else {
                                            objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        CanvasKt.Canvas(modifierFillMaxSize$default1111111, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1078222008);
                                        int i31111111111111111111111115 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                        ContentScale contentScale1111111111111111118 = contentScale4;
                                        m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale1111111111111111118, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111111115, 388);
                                        colorFilter4 = colorFilter4;
                                        contentScale4 = contentScale1111111111111111118;
                                        i24 = i24;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                            }
                            i24 = i25;
                        }
                    }
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj5;
                map2 = map5;
                colorFilter3 = colorFilter4;
                i23 = i24;
                str5 = str9;
                str4 = str7;
                contentScale3 = contentScale4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                obj3 = obj2;
                str4 = str2;
                colorFilter3 = colorFilter2;
                contentScale3 = contentScale2;
                str5 = str3;
                i23 = i18;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj8, Object obj9) {
                        return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                    }
                });
            }
        }
        i13 |= 100663296;
        if ((i13 & 38347923) != 38347922) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) != 0) {
                if ((i12 & 4) != 0) {
                    image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                    i13 &= -897;
                } else {
                    image = obj2;
                }
                if (i26 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i16 != 0) {
                    str3 = "";
                }
                if ((i12 & 64) != 0) {
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    i13 &= -3670017;
                } else {
                    iM5965getHighfv9h1I = i18;
                }
                if (i19 != 0) {
                    map3 = null;
                } else {
                    map3 = map;
                }
                String str1119 = str3;
                obj4 = image;
                str6 = str1119;
                contentScale4 = fit;
                if (i21 != 0) {
                    i24 = iM5965getHighfv9h1I;
                    map4 = map3;
                    colorFilter4 = colorFilter2;
                    str7 = "";
                } else {
                    i24 = iM5965getHighfv9h1I;
                    map4 = map3;
                    colorFilter4 = colorFilter2;
                    str7 = str2;
                }
            } else {
                if ((i12 & 4) != 0) {
                    image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                    i13 &= -897;
                } else {
                    image = obj2;
                }
                if (i26 != 0) {
                    colorFilter2 = null;
                }
                if (i14 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i16 != 0) {
                    str3 = "";
                }
                if ((i12 & 64) != 0) {
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    i13 &= -3670017;
                } else {
                    iM5965getHighfv9h1I = i18;
                }
                if (i19 != 0) {
                    map3 = null;
                } else {
                    map3 = map;
                }
                String str11110 = str3;
                obj4 = image;
                str6 = str11110;
                contentScale4 = fit;
                if (i21 != 0) {
                    i24 = iM5965getHighfv9h1I;
                    map4 = map3;
                    colorFilter4 = colorFilter2;
                    str7 = "";
                } else {
                    i24 = iM5965getHighfv9h1I;
                    map4 = map3;
                    colorFilter4 = colorFilter2;
                    str7 = str2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(330630401, i13, -1, "cu.z17.views.picture.Z17BasePicture (Z17Picture.kt:38)");
            }
            int i2111111115 = i13 & 14;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion17 = ComposeUiNode.INSTANCE;
            constructor = companion17.getConstructor();
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
            str8 = str6;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy17, companion17.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap17, companion17.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion17.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting()) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier17, companion17.getSetModifier());
            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
            if (obj == null) {
                str9 = str8;
                if (obj instanceof String) {
                    obj5 = obj4;
                    colorFilter5 = colorFilter4;
                    map5 = map4;
                    if (obj instanceof Uri) {
                        composerStartRestartGroup.startReplaceGroup(1075859374);
                        int i2111111116 = i13 >> 6;
                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111116 & 896) | 6 | (i2111111116 & 7168) | (i2111111116 & 57344), 32);
                        str9 = str9;
                        composerStartRestartGroup.endReplaceGroup();
                        colorFilter4 = colorFilter5;
                    } else {
                        if (obj instanceof Integer) {
                            composerStartRestartGroup.startReplaceGroup(1076190330);
                            int i31111111111111111111111116 = i24;
                            ContentScale contentScale1111111111111111119 = contentScale4;
                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale1111111111111111119, 0.0f, colorFilter5, i31111111111111111111111116, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                            str9 = str9;
                            contentScale4 = contentScale1111111111111111119;
                            colorFilter4 = colorFilter5;
                            i25 = i31111111111111111111111116;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            colorFilter4 = colorFilter5;
                            i25 = i24;
                            if (obj instanceof ImageVector) {
                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                ContentScale contentScale11111111111111111110 = contentScale4;
                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111111110, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111111110;
                                colorFilter4 = colorFilter4;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (obj instanceof Bitmap) {
                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    obj7 = objRememberedValue3;
                                    Bitmap bitmap1111112 = (Bitmap) obj;
                                    bitmap1111112.prepareToDraw();
                                    composerStartRestartGroup.updateRememberedValue(bitmap1111112);
                                    obj7 = bitmap1111112;
                                }
                                obj7 = objRememberedValue3;
                                int i31111111111111111111111117 = i13 >> 6;
                                i24 = i25;
                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i31111111111111111111111117 & 112) | 6 | (i31111111111111111111111117 & 896) | (i31111111111111111111111117 & 7168) | (i31111111111111111111111117 & 57344), 64);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                i24 = i25;
                                if (obj instanceof Drawable) {
                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        obj6 = objRememberedValue2;
                                        Bitmap bitmap$default1111112 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                        bitmap$default1111112.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap$default1111112);
                                        obj6 = bitmap$default1111112;
                                    }
                                    obj6 = objRememberedValue2;
                                    int i31111111111111111111111118 = i13 >> 6;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i31111111111111111111111118 & 112) | 6 | (i31111111111111111111111118 & 896) | (i31111111111111111111111118 & 7168) | (i31111111111111111111111118 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Color) {
                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                    Modifier modifierFillMaxSize$default1111112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    CanvasKt.Canvas(modifierFillMaxSize$default1111112, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                    int i31111111111111111111111119 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                    ContentScale contentScale11111111111111111111 = contentScale4;
                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111111111, str9, i24, null, null, composerStartRestartGroup, i31111111111111111111111119, 388);
                                    colorFilter4 = colorFilter4;
                                    contentScale4 = contentScale11111111111111111111;
                                    i24 = i24;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                        i24 = i25;
                    }
                } else {
                    obj5 = obj4;
                    colorFilter5 = colorFilter4;
                    map5 = map4;
                    if (obj instanceof Uri) {
                        composerStartRestartGroup.startReplaceGroup(1075859374);
                        int i2111111117 = i13 >> 6;
                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111117 & 896) | 6 | (i2111111117 & 7168) | (i2111111117 & 57344), 32);
                        str9 = str9;
                        composerStartRestartGroup.endReplaceGroup();
                        colorFilter4 = colorFilter5;
                    } else {
                        if (obj instanceof Integer) {
                            composerStartRestartGroup.startReplaceGroup(1076190330);
                            int i311111111111111111111111110 = i24;
                            ContentScale contentScale11111111111111111112 = contentScale4;
                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111111112, 0.0f, colorFilter5, i311111111111111111111111110, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                            str9 = str9;
                            contentScale4 = contentScale11111111111111111112;
                            colorFilter4 = colorFilter5;
                            i25 = i311111111111111111111111110;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            colorFilter4 = colorFilter5;
                            i25 = i24;
                            if (obj instanceof ImageVector) {
                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                ContentScale contentScale11111111111111111113 = contentScale4;
                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111111113, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111111113;
                                colorFilter4 = colorFilter4;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (obj instanceof Bitmap) {
                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    obj7 = objRememberedValue3;
                                    Bitmap bitmap1111113 = (Bitmap) obj;
                                    bitmap1111113.prepareToDraw();
                                    composerStartRestartGroup.updateRememberedValue(bitmap1111113);
                                    obj7 = bitmap1111113;
                                }
                                obj7 = objRememberedValue3;
                                int i311111111111111111111111111 = i13 >> 6;
                                i24 = i25;
                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111111111 & 112) | 6 | (i311111111111111111111111111 & 896) | (i311111111111111111111111111 & 7168) | (i311111111111111111111111111 & 57344), 64);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                i24 = i25;
                                if (obj instanceof Drawable) {
                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        obj6 = objRememberedValue2;
                                        Bitmap bitmap$default1111113 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                        bitmap$default1111113.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap$default1111113);
                                        obj6 = bitmap$default1111113;
                                    }
                                    obj6 = objRememberedValue2;
                                    int i311111111111111111111111112 = i13 >> 6;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111111111112 & 112) | 6 | (i311111111111111111111111112 & 896) | (i311111111111111111111111112 & 7168) | (i311111111111111111111111112 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Color) {
                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                    Modifier modifierFillMaxSize$default1111113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    CanvasKt.Canvas(modifierFillMaxSize$default1111113, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                    int i311111111111111111111111113 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                    ContentScale contentScale11111111111111111114 = contentScale4;
                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111111114, str9, i24, null, null, composerStartRestartGroup, i311111111111111111111111113, 388);
                                    colorFilter4 = colorFilter4;
                                    contentScale4 = contentScale11111111111111111114;
                                    i24 = i24;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                        i24 = i25;
                    }
                }
            } else {
                str9 = str8;
                if (obj instanceof String) {
                    obj5 = obj4;
                    colorFilter5 = colorFilter4;
                    map5 = map4;
                    if (obj instanceof Uri) {
                        composerStartRestartGroup.startReplaceGroup(1075859374);
                        int i2111111118 = i13 >> 6;
                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111118 & 896) | 6 | (i2111111118 & 7168) | (i2111111118 & 57344), 32);
                        str9 = str9;
                        composerStartRestartGroup.endReplaceGroup();
                        colorFilter4 = colorFilter5;
                    } else {
                        if (obj instanceof Integer) {
                            composerStartRestartGroup.startReplaceGroup(1076190330);
                            int i311111111111111111111111114 = i24;
                            ContentScale contentScale11111111111111111115 = contentScale4;
                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111111115, 0.0f, colorFilter5, i311111111111111111111111114, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                            str9 = str9;
                            contentScale4 = contentScale11111111111111111115;
                            colorFilter4 = colorFilter5;
                            i25 = i311111111111111111111111114;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            colorFilter4 = colorFilter5;
                            i25 = i24;
                            if (obj instanceof ImageVector) {
                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                ContentScale contentScale11111111111111111116 = contentScale4;
                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111111116, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111111116;
                                colorFilter4 = colorFilter4;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (obj instanceof Bitmap) {
                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    obj7 = objRememberedValue3;
                                    Bitmap bitmap1111114 = (Bitmap) obj;
                                    bitmap1111114.prepareToDraw();
                                    composerStartRestartGroup.updateRememberedValue(bitmap1111114);
                                    obj7 = bitmap1111114;
                                }
                                obj7 = objRememberedValue3;
                                int i311111111111111111111111115 = i13 >> 6;
                                i24 = i25;
                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111111115 & 112) | 6 | (i311111111111111111111111115 & 896) | (i311111111111111111111111115 & 7168) | (i311111111111111111111111115 & 57344), 64);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                i24 = i25;
                                if (obj instanceof Drawable) {
                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        obj6 = objRememberedValue2;
                                        Bitmap bitmap$default1111114 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                        bitmap$default1111114.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap$default1111114);
                                        obj6 = bitmap$default1111114;
                                    }
                                    obj6 = objRememberedValue2;
                                    int i311111111111111111111111116 = i13 >> 6;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i311111111111111111111111116 & 112) | 6 | (i311111111111111111111111116 & 896) | (i311111111111111111111111116 & 7168) | (i311111111111111111111111116 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Color) {
                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                    Modifier modifierFillMaxSize$default1111114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    CanvasKt.Canvas(modifierFillMaxSize$default1111114, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                    int i311111111111111111111111117 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                    ContentScale contentScale11111111111111111117 = contentScale4;
                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale11111111111111111117, str9, i24, null, null, composerStartRestartGroup, i311111111111111111111111117, 388);
                                    colorFilter4 = colorFilter4;
                                    contentScale4 = contentScale11111111111111111117;
                                    i24 = i24;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                        i24 = i25;
                    }
                } else {
                    obj5 = obj4;
                    colorFilter5 = colorFilter4;
                    map5 = map4;
                    if (obj instanceof Uri) {
                        composerStartRestartGroup.startReplaceGroup(1075859374);
                        int i2111111119 = i13 >> 6;
                        Z17PictureSourceKt.m10280PictureFromUriEHKIwbg(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Uri) obj, contentScale4, str9, i24, null, composerStartRestartGroup, (i2111111119 & 896) | 6 | (i2111111119 & 7168) | (i2111111119 & 57344), 32);
                        str9 = str9;
                        composerStartRestartGroup.endReplaceGroup();
                        colorFilter4 = colorFilter5;
                    } else {
                        if (obj instanceof Integer) {
                            composerStartRestartGroup.startReplaceGroup(1076190330);
                            int i311111111111111111111111118 = i24;
                            ContentScale contentScale11111111111111111118 = contentScale4;
                            SingletonAsyncImageKt.m9774AsyncImagegl8XCv8(Integer.valueOf(((Number) obj).intValue()), str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, contentScale11111111111111111118, 0.0f, colorFilter5, i311111111111111111111111118, false, null, composerStartRestartGroup, (3670016 & (i13 << 6)) | ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i13 << 15) & 234881024) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), 0, 3256);
                            str9 = str9;
                            contentScale4 = contentScale11111111111111111118;
                            colorFilter4 = colorFilter5;
                            i25 = i311111111111111111111111118;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            colorFilter4 = colorFilter5;
                            i25 = i24;
                            if (obj instanceof ImageVector) {
                                composerStartRestartGroup.startReplaceGroup(1076577613);
                                ContentScale contentScale11111111111111111119 = contentScale4;
                                androidx.compose.foundation.ImageKt.Image((ImageVector) obj, str9, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, contentScale11111111111111111119, 0.0f, colorFilter4, composerStartRestartGroup, ((i13 >> 12) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 57344) | ((i13 << 9) & 3670016), 40);
                                str9 = str9;
                                contentScale4 = contentScale11111111111111111119;
                                colorFilter4 = colorFilter4;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (obj instanceof Bitmap) {
                                composerStartRestartGroup.startReplaceGroup(1076916505);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    obj7 = objRememberedValue3;
                                    Bitmap bitmap1111115 = (Bitmap) obj;
                                    bitmap1111115.prepareToDraw();
                                    composerStartRestartGroup.updateRememberedValue(bitmap1111115);
                                    obj7 = bitmap1111115;
                                }
                                obj7 = objRememberedValue3;
                                int i311111111111111111111111119 = i13 >> 6;
                                i24 = i25;
                                Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj7, null, composerStartRestartGroup, (i311111111111111111111111119 & 112) | 6 | (i311111111111111111111111119 & 896) | (i311111111111111111111111119 & 7168) | (i311111111111111111111111119 & 57344), 64);
                                str9 = str9;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                i24 = i25;
                                if (obj instanceof Drawable) {
                                    composerStartRestartGroup.startReplaceGroup(1077431663);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        obj6 = objRememberedValue2;
                                        Bitmap bitmap$default1111115 = DrawableKt.toBitmap$default((Drawable) obj, 0, 0, null, 7, null);
                                        bitmap$default1111115.prepareToDraw();
                                        composerStartRestartGroup.updateRememberedValue(bitmap$default1111115);
                                        obj6 = bitmap$default1111115;
                                    }
                                    obj6 = objRememberedValue2;
                                    int i3111111111111111111111111110 = i13 >> 6;
                                    Z17PictureSourceKt.m10279PictureFromBitmap6tVf_Uk(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colorFilter4, contentScale4, str9, i24, (Bitmap) obj6, null, composerStartRestartGroup, (i3111111111111111111111111110 & 112) | 6 | (i3111111111111111111111111110 & 896) | (i3111111111111111111111111110 & 7168) | (i3111111111111111111111111110 & 57344), 64);
                                    str9 = str9;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (obj instanceof Color) {
                                    composerStartRestartGroup.startReplaceGroup(1077974876);
                                    Modifier modifierFillMaxSize$default1111115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    zChangedInstance = composerStartRestartGroup.changedInstance(obj);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        objRememberedValue = new Function1() { // from class: cu.z17.views.picture.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(obj, (DrawScope) obj8);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    CanvasKt.Canvas(modifierFillMaxSize$default1111115, (Function1) objRememberedValue, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1078222008);
                                    int i3111111111111111111111111111 = ((i13 >> 3) & 112) | 6 | (i13 & 7168) | (i13 & 57344) | (i13 & 458752) | (i13 & 3670016);
                                    ContentScale contentScale111111111111111111110 = contentScale4;
                                    m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), obj5, null, colorFilter4, contentScale111111111111111111110, str9, i24, null, null, composerStartRestartGroup, i3111111111111111111111111111, 388);
                                    colorFilter4 = colorFilter4;
                                    contentScale4 = contentScale111111111111111111110;
                                    i24 = i24;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                        i24 = i25;
                    }
                }
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj3 = obj5;
            map2 = map5;
            colorFilter3 = colorFilter4;
            i23 = i24;
            str5 = str9;
            str4 = str7;
            contentScale3 = contentScale4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            obj3 = obj2;
            str4 = str2;
            colorFilter3 = colorFilter2;
            contentScale3 = contentScale2;
            str5 = str3;
            i23 = i18;
            map2 = map;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj8, Object obj9) {
                    return Z17PictureKt.Z17BasePicture_C8z9wKI$lambda$5(modifier, obj, obj3, colorFilter3, contentScale3, str5, i23, map2, str4, i11, i12, (Composer) obj8, ((Integer) obj9).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BasePicture_C8z9wKI$lambda$4$lambda$3$lambda$2(Object obj, DrawScope Canvas) {
        y.i(Canvas, "$this$Canvas");
        DrawScope.CC.M(Canvas, ((Color) obj).m5876unboximpl(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17BasePicture_C8z9wKI$lambda$5(Modifier modifier, Object obj, Object obj2, ColorFilter colorFilter, ContentScale contentScale, String str, int i10, Map map, String str2, int i11, int i12, Composer composer, int i13) {
        m10278Z17BasePictureC8z9wKI(modifier, obj, obj2, colorFilter, contentScale, str, i10, map, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
