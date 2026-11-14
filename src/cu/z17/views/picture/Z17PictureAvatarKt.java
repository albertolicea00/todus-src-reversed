package cu.z17.views.picture;

import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.PersonKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.z17.views.R;
import cu.z17.views.utils.Z17InlineUtilsKt;
import defpackage.r;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0099\u0001\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", NewEntity.NEWS_CONFIG_SOURCE, "placeholder", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "", "description", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "", "size", "", "canEdit", "", "customHeaders", "textPlaceholder", "useTextPlaceholder", "defaultAvatarSize", "Lua/k0;", "Z17PictureAvatar-ajT4Zlk", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/graphics/ColorFilter;Ljava/lang/String;ILjava/lang/Integer;ZLjava/util/Map;Ljava/lang/String;ZILandroidx/compose/runtime/Composer;III)V", "Z17PictureAvatar", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17PictureAvatarKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0125  */
    /* JADX WARN: Code duplicated, block: B:102:0x0128  */
    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0142  */
    /* JADX WARN: Code duplicated, block: B:113:0x014c  */
    /* JADX WARN: Code duplicated, block: B:114:0x014f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0154  */
    /* JADX WARN: Code duplicated, block: B:119:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x0171  */
    /* JADX WARN: Code duplicated, block: B:126:0x017a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0185  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:153:0x01db  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:162:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:166:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:168:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:169:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:172:0x020c  */
    /* JADX WARN: Code duplicated, block: B:174:0x0214  */
    /* JADX WARN: Code duplicated, block: B:177:0x0220  */
    /* JADX WARN: Code duplicated, block: B:180:0x0255  */
    /* JADX WARN: Code duplicated, block: B:183:0x0261  */
    /* JADX WARN: Code duplicated, block: B:184:0x0265  */
    /* JADX WARN: Code duplicated, block: B:187:0x0284  */
    /* JADX WARN: Code duplicated, block: B:189:0x0292  */
    /* JADX WARN: Code duplicated, block: B:192:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:198:0x02c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:201:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:203:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:207:0x0389  */
    /* JADX WARN: Code duplicated, block: B:209:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:212:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:214:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:217:0x040a  */
    /* JADX WARN: Code duplicated, block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x010e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x011b  */
    @Composable
    /* JADX INFO: renamed from: Z17PictureAvatar-ajT4Zlk, reason: not valid java name */
    public static final void m10277Z17PictureAvatarajT4Zlk(Modifier modifier, final Object obj, Object obj2, ColorFilter colorFilter, String str, int i10, Integer num, boolean z10, Map<String, String> map, String str2, boolean z11, int i11, Composer composer, final int i12, final int i13, final int i14) {
        Modifier modifier2;
        int i15;
        Object obj3;
        ColorFilter colorFilter2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z12;
        final int i30;
        final boolean z13;
        final String str3;
        final boolean z14;
        final int i31;
        final Modifier modifier3;
        final Object obj4;
        Composer composer2;
        final ColorFilter colorFilter3;
        final String str4;
        final Integer num2;
        final Map<String, String> map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Object person;
        String str5;
        int iM5965getHighfv9h1I;
        Integer num3;
        boolean z15;
        Map<String, String> map3;
        String str6;
        boolean z16;
        Integer num4;
        boolean z17;
        int i32;
        ColorFilter colorFilter4;
        boolean z18;
        int i33;
        Modifier modifier5;
        Object obj5;
        String str7;
        Map<String, String> map4;
        int currentCompositeKeyHash;
        lb.a constructor;
        Composer composerM5176constructorimpl;
        Function2 setCompositeKeyHash;
        int color;
        String str8;
        int i34;
        String str9;
        Object obj6;
        int i35;
        int i36;
        Composer composerStartRestartGroup = composer.startRestartGroup(-292953079);
        int i37 = i14 & 1;
        if (i37 != 0) {
            i15 = i12 | 6;
            modifier2 = modifier;
        } else if ((i12 & 6) == 0) {
            modifier2 = modifier;
            i15 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i12;
        } else {
            modifier2 = modifier;
            i15 = i12;
        }
        if ((i12 & 48) == 0) {
            i15 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i14 & 4) == 0) {
                obj3 = obj2;
                int i38 = composerStartRestartGroup.changedInstance(obj3) ? 256 : 128;
                i15 |= i38;
            } else {
                obj3 = obj2;
            }
            i15 |= i38;
        } else {
            obj3 = obj2;
        }
        int i39 = i14 & 8;
        if (i39 == 0) {
            if ((i12 & 3072) == 0) {
                colorFilter2 = colorFilter;
                i15 |= composerStartRestartGroup.changed(colorFilter2) ? 2048 : 1024;
            }
            i16 = i14 & 16;
            if (i16 != 0) {
                if ((i12 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i17 = 16384;
                    } else {
                        i17 = 8192;
                    }
                    i15 |= i17;
                }
                if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                    if ((i14 & 32) == 0 || !composerStartRestartGroup.changed(i10)) {
                        i36 = 65536;
                    } else {
                        i36 = 131072;
                    }
                    i15 |= i36;
                }
                i18 = i14 & 128;
                if (i18 != 0) {
                    i15 |= 12582912;
                } else if ((i12 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z10)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i15 |= i19;
                }
                i20 = i14 & 256;
                if (i20 != 0) {
                    i15 |= 100663296;
                } else if ((i12 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(map)) {
                        i21 = 67108864;
                    } else {
                        i21 = 33554432;
                    }
                    i15 |= i21;
                }
                i22 = i14 & 512;
                if (i22 != 0) {
                    if ((i12 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(str2)) {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i23 = 268435456;
                        }
                        i15 |= i23;
                    }
                    i24 = i14 & 1024;
                    if (i24 != 0) {
                        i25 = i13 | 6;
                    } else if ((i13 & 6) == 0) {
                        if (composerStartRestartGroup.changed(z11)) {
                            i26 = 4;
                        } else {
                            i26 = 2;
                        }
                        i25 = i13 | i26;
                    } else {
                        i25 = i13;
                    }
                    i27 = i14 & 2048;
                    if (i27 != 0) {
                        i25 |= 48;
                    } else if ((i13 & 48) != 0) {
                        if (composerStartRestartGroup.changed(i11)) {
                            i28 = 32;
                        } else {
                            i28 = 16;
                        }
                        i25 |= i28;
                    }
                    i29 = i25;
                    if ((i15 & 306259091) == 306259090 || (i29 & 19) != 18) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i12 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i37 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if ((i14 & 4) != 0) {
                                person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                                i15 &= -897;
                            } else {
                                person = obj3;
                            }
                            if (i39 != 0) {
                                colorFilter2 = null;
                            }
                            if (i16 != 0) {
                                str5 = "avatar image";
                            } else {
                                str5 = str;
                            }
                            if ((i14 & 32) != 0) {
                                iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                                i15 = (-458753) & i15;
                            } else {
                                iM5965getHighfv9h1I = i10;
                            }
                            if ((i14 & 64) != 0) {
                                num3 = null;
                            } else {
                                num3 = num;
                            }
                            if (i18 != 0) {
                                z15 = false;
                            } else {
                                z15 = z10;
                            }
                            if (i20 != 0) {
                                map3 = null;
                            } else {
                                map3 = map;
                            }
                            if (i22 != 0) {
                                str6 = "";
                            } else {
                                str6 = str2;
                            }
                            if (i24 != 0) {
                                z16 = false;
                            } else {
                                z16 = z11;
                            }
                            num4 = num3;
                            z17 = z15;
                            i32 = iM5965getHighfv9h1I;
                            colorFilter4 = colorFilter2;
                            z18 = z16;
                            if (i27 != 0) {
                                i33 = 256;
                            } else {
                                i33 = i11;
                            }
                            modifier5 = modifier4;
                            obj5 = person;
                            str7 = str5;
                            map4 = map3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i14 & 4) != 0) {
                                i15 &= -897;
                            }
                            if ((i14 & 32) != 0) {
                                i15 &= -458753;
                            }
                            i32 = i10;
                            num4 = num;
                            z17 = z10;
                            str6 = str2;
                            z18 = z11;
                            i33 = i11;
                            obj5 = obj3;
                            colorFilter4 = colorFilter2;
                            map4 = map;
                            modifier5 = modifier2;
                            str7 = str;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                        }
                        Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default);
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
                        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if ((obj != null || ((obj instanceof String) && d0.q0((CharSequence) obj))) && z18) {
                            composerStartRestartGroup.startReplaceGroup(1179971772);
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                            if (obj5 instanceof Color) {
                                color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                            } else {
                                color = android.graphics.Color.parseColor("#9c9c9c");
                            }
                            int i40 = i33;
                            String str10 = str6;
                            str8 = str10;
                            i34 = i40;
                            int i41 = (i15 & 7168) | 100687872;
                            int i42 = i15 << 3;
                            str9 = str7;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default, Z17InlineUtilsKt.asBitmap(str10, color, i40, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i41 | (458752 & i42) | (3670016 & i42), 132);
                            composerStartRestartGroup.endReplaceGroup();
                            obj6 = null;
                            i35 = 1;
                        } else {
                            i34 = i33;
                            str9 = str7;
                            str8 = str6;
                            composerStartRestartGroup.startReplaceGroup(1180752290);
                            int i43 = i15 << 3;
                            obj6 = null;
                            i35 = 1;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null), obj, obj5, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, map4, null, composerStartRestartGroup, (i15 & 896) | (i15 & 112) | 24576 | (i15 & 7168) | (458752 & i43) | (i43 & 3670016) | (29360128 & (i15 >> 3)), 256);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (z17) {
                            composerStartRestartGroup.startReplaceGroup(592293339);
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                            composerStartRestartGroup = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1178554111);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj4 = obj5;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        map2 = map4;
                        colorFilter3 = colorFilter4;
                        str4 = str9;
                        i30 = i32;
                        num2 = num4;
                        z13 = z17;
                        z14 = z18;
                        str3 = str8;
                        i31 = i34;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i30 = i10;
                        z13 = z10;
                        str3 = str2;
                        z14 = z11;
                        i31 = i11;
                        modifier3 = modifier2;
                        obj4 = obj3;
                        composer2 = composerStartRestartGroup;
                        colorFilter3 = colorFilter2;
                        str4 = str;
                        num2 = num;
                        map2 = map;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj7, Object obj8) {
                                return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                            }
                        });
                    }
                }
                i15 |= 805306368;
                i24 = i14 & 1024;
                if (i24 != 0) {
                    i25 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i26 = 4;
                    } else {
                        i26 = 2;
                    }
                    i25 = i13 | i26;
                } else {
                    i25 = i13;
                }
                i27 = i14 & 2048;
                if (i27 != 0) {
                    i25 |= 48;
                } else if ((i13 & 48) != 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i28 = 32;
                    } else {
                        i28 = 16;
                    }
                    i25 |= i28;
                }
                i29 = i25;
                if ((i15 & 306259091) == 306259090) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    } else {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                    }
                    Modifier modifierAspectRatio$default2 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default2);
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
                    if (obj != null) {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i44 = i33;
                        String str11 = str6;
                        str8 = str11;
                        i34 = i44;
                        int i45 = (i15 & 7168) | 100687872;
                        int i46 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default2, Z17InlineUtilsKt.asBitmap(str11, color, i44, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i45 | (458752 & i46) | (3670016 & i46), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i47 = i33;
                        String str12 = str6;
                        str8 = str12;
                        i34 = i47;
                        int i48 = (i15 & 7168) | 100687872;
                        int i49 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default3, Z17InlineUtilsKt.asBitmap(str12, color, i47, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i48 | (458752 & i49) | (3670016 & i49), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    }
                    if (z17) {
                        composerStartRestartGroup.startReplaceGroup(592293339);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1178554111);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = obj5;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    map2 = map4;
                    colorFilter3 = colorFilter4;
                    str4 = str9;
                    i30 = i32;
                    num2 = num4;
                    z13 = z17;
                    z14 = z18;
                    str3 = str8;
                    i31 = i34;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i30 = i10;
                    z13 = z10;
                    str3 = str2;
                    z14 = z11;
                    i31 = i11;
                    modifier3 = modifier2;
                    obj4 = obj3;
                    composer2 = composerStartRestartGroup;
                    colorFilter3 = colorFilter2;
                    str4 = str;
                    num2 = num;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                        }
                    });
                }
            }
            i15 |= 24576;
            if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i14 & 32) == 0) {
                    i36 = 65536;
                } else {
                    i36 = 65536;
                }
                i15 |= i36;
            }
            i18 = i14 & 128;
            if (i18 != 0) {
                i15 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i15 |= i19;
            }
            i20 = i14 & 256;
            if (i20 != 0) {
                i15 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(map)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i15 |= i21;
            }
            i22 = i14 & 512;
            if (i22 != 0) {
                if ((i12 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i15 |= i23;
                }
                i24 = i14 & 1024;
                if (i24 != 0) {
                    i25 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i26 = 4;
                    } else {
                        i26 = 2;
                    }
                    i25 = i13 | i26;
                } else {
                    i25 = i13;
                }
                i27 = i14 & 2048;
                if (i27 != 0) {
                    i25 |= 48;
                } else if ((i13 & 48) != 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i28 = 32;
                    } else {
                        i28 = 16;
                    }
                    i25 |= i28;
                }
                i29 = i25;
                if ((i15 & 306259091) == 306259090) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    } else {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                    }
                    Modifier modifierAspectRatio$default3 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default3);
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
                    if (obj != null) {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i410 = i33;
                        String str13 = str6;
                        str8 = str13;
                        i34 = i410;
                        int i411 = (i15 & 7168) | 100687872;
                        int i412 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default4, Z17InlineUtilsKt.asBitmap(str13, color, i410, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i411 | (458752 & i412) | (3670016 & i412), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i413 = i33;
                        String str14 = str6;
                        str8 = str14;
                        i34 = i413;
                        int i414 = (i15 & 7168) | 100687872;
                        int i415 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default5, Z17InlineUtilsKt.asBitmap(str14, color, i413, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i414 | (458752 & i415) | (3670016 & i415), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    }
                    if (z17) {
                        composerStartRestartGroup.startReplaceGroup(592293339);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1178554111);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = obj5;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    map2 = map4;
                    colorFilter3 = colorFilter4;
                    str4 = str9;
                    i30 = i32;
                    num2 = num4;
                    z13 = z17;
                    z14 = z18;
                    str3 = str8;
                    i31 = i34;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i30 = i10;
                    z13 = z10;
                    str3 = str2;
                    z14 = z11;
                    i31 = i11;
                    modifier3 = modifier2;
                    obj4 = obj3;
                    composer2 = composerStartRestartGroup;
                    colorFilter3 = colorFilter2;
                    str4 = str;
                    num2 = num;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                        }
                    });
                }
            }
            i15 |= 805306368;
            i24 = i14 & 1024;
            if (i24 != 0) {
                i25 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i26 = 4;
                } else {
                    i26 = 2;
                }
                i25 = i13 | i26;
            } else {
                i25 = i13;
            }
            i27 = i14 & 2048;
            if (i27 != 0) {
                i25 |= 48;
            } else if ((i13 & 48) != 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i28 = 32;
                } else {
                    i28 = 16;
                }
                i25 |= i28;
            }
            i29 = i25;
            if ((i15 & 306259091) == 306259090) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                } else {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                }
                Modifier modifierAspectRatio$default4 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default4);
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
                if (obj != null) {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i416 = i33;
                    String str15 = str6;
                    str8 = str15;
                    i34 = i416;
                    int i417 = (i15 & 7168) | 100687872;
                    int i418 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default6, Z17InlineUtilsKt.asBitmap(str15, color, i416, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i417 | (458752 & i418) | (3670016 & i418), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i419 = i33;
                    String str16 = str6;
                    str8 = str16;
                    i34 = i419;
                    int i4110 = (i15 & 7168) | 100687872;
                    int i4111 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default7, Z17InlineUtilsKt.asBitmap(str16, color, i419, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i4110 | (458752 & i4111) | (3670016 & i4111), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                }
                if (z17) {
                    composerStartRestartGroup.startReplaceGroup(592293339);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1178554111);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj5;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                map2 = map4;
                colorFilter3 = colorFilter4;
                str4 = str9;
                i30 = i32;
                num2 = num4;
                z13 = z17;
                z14 = z18;
                str3 = str8;
                i31 = i34;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i30 = i10;
                z13 = z10;
                str3 = str2;
                z14 = z11;
                i31 = i11;
                modifier3 = modifier2;
                obj4 = obj3;
                composer2 = composerStartRestartGroup;
                colorFilter3 = colorFilter2;
                str4 = str;
                num2 = num;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj7, Object obj8) {
                        return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                    }
                });
            }
        }
        i15 |= 3072;
        colorFilter2 = colorFilter;
        i16 = i14 & 16;
        if (i16 != 0) {
            if ((i12 & 24576) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i17 = 16384;
                } else {
                    i17 = 8192;
                }
                i15 |= i17;
            }
            if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i14 & 32) == 0) {
                    i36 = 65536;
                } else {
                    i36 = 65536;
                }
                i15 |= i36;
            }
            i18 = i14 & 128;
            if (i18 != 0) {
                i15 |= 12582912;
            } else if ((i12 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z10)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i15 |= i19;
            }
            i20 = i14 & 256;
            if (i20 != 0) {
                i15 |= 100663296;
            } else if ((i12 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(map)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i15 |= i21;
            }
            i22 = i14 & 512;
            if (i22 != 0) {
                if ((i12 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i23 = 268435456;
                    }
                    i15 |= i23;
                }
                i24 = i14 & 1024;
                if (i24 != 0) {
                    i25 = i13 | 6;
                } else if ((i13 & 6) == 0) {
                    if (composerStartRestartGroup.changed(z11)) {
                        i26 = 4;
                    } else {
                        i26 = 2;
                    }
                    i25 = i13 | i26;
                } else {
                    i25 = i13;
                }
                i27 = i14 & 2048;
                if (i27 != 0) {
                    i25 |= 48;
                } else if ((i13 & 48) != 0) {
                    if (composerStartRestartGroup.changed(i11)) {
                        i28 = 32;
                    } else {
                        i28 = 16;
                    }
                    i25 |= i28;
                }
                i29 = i25;
                if ((i15 & 306259091) == 306259090) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i12 & 1) != 0) {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    } else {
                        if (i37 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i14 & 4) != 0) {
                            person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                            i15 &= -897;
                        } else {
                            person = obj3;
                        }
                        if (i39 != 0) {
                            colorFilter2 = null;
                        }
                        if (i16 != 0) {
                            str5 = "avatar image";
                        } else {
                            str5 = str;
                        }
                        if ((i14 & 32) != 0) {
                            iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                            i15 = (-458753) & i15;
                        } else {
                            iM5965getHighfv9h1I = i10;
                        }
                        if ((i14 & 64) != 0) {
                            num3 = null;
                        } else {
                            num3 = num;
                        }
                        if (i18 != 0) {
                            z15 = false;
                        } else {
                            z15 = z10;
                        }
                        if (i20 != 0) {
                            map3 = null;
                        } else {
                            map3 = map;
                        }
                        if (i22 != 0) {
                            str6 = "";
                        } else {
                            str6 = str2;
                        }
                        if (i24 != 0) {
                            z16 = false;
                        } else {
                            z16 = z11;
                        }
                        num4 = num3;
                        z17 = z15;
                        i32 = iM5965getHighfv9h1I;
                        colorFilter4 = colorFilter2;
                        z18 = z16;
                        if (i27 != 0) {
                            i33 = 256;
                        } else {
                            i33 = i11;
                        }
                        modifier5 = modifier4;
                        obj5 = person;
                        str7 = str5;
                        map4 = map3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                    }
                    Modifier modifierAspectRatio$default5 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default5);
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
                    if (obj != null) {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i4112 = i33;
                        String str17 = str6;
                        str8 = str17;
                        i34 = i4112;
                        int i4113 = (i15 & 7168) | 100687872;
                        int i4114 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default8, Z17InlineUtilsKt.asBitmap(str17, color, i4112, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i4113 | (458752 & i4114) | (3670016 & i4114), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1179971772);
                        Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                        if (obj5 instanceof Color) {
                            color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                        } else {
                            color = android.graphics.Color.parseColor("#9c9c9c");
                        }
                        int i4115 = i33;
                        String str18 = str6;
                        str8 = str18;
                        i34 = i4115;
                        int i4116 = (i15 & 7168) | 100687872;
                        int i4117 = i15 << 3;
                        str9 = str7;
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default9, Z17InlineUtilsKt.asBitmap(str18, color, i4115, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i4116 | (458752 & i4117) | (3670016 & i4117), 132);
                        composerStartRestartGroup.endReplaceGroup();
                        obj6 = null;
                        i35 = 1;
                    }
                    if (z17) {
                        composerStartRestartGroup.startReplaceGroup(592293339);
                        Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1178554111);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj4 = obj5;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    map2 = map4;
                    colorFilter3 = colorFilter4;
                    str4 = str9;
                    i30 = i32;
                    num2 = num4;
                    z13 = z17;
                    z14 = z18;
                    str3 = str8;
                    i31 = i34;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    i30 = i10;
                    z13 = z10;
                    str3 = str2;
                    z14 = z11;
                    i31 = i11;
                    modifier3 = modifier2;
                    obj4 = obj3;
                    composer2 = composerStartRestartGroup;
                    colorFilter3 = colorFilter2;
                    str4 = str;
                    num2 = num;
                    map2 = map;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                        }
                    });
                }
            }
            i15 |= 805306368;
            i24 = i14 & 1024;
            if (i24 != 0) {
                i25 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i26 = 4;
                } else {
                    i26 = 2;
                }
                i25 = i13 | i26;
            } else {
                i25 = i13;
            }
            i27 = i14 & 2048;
            if (i27 != 0) {
                i25 |= 48;
            } else if ((i13 & 48) != 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i28 = 32;
                } else {
                    i28 = 16;
                }
                i25 |= i28;
            }
            i29 = i25;
            if ((i15 & 306259091) == 306259090) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                } else {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                }
                Modifier modifierAspectRatio$default6 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default6);
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
                if (obj != null) {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i4118 = i33;
                    String str19 = str6;
                    str8 = str19;
                    i34 = i4118;
                    int i4119 = (i15 & 7168) | 100687872;
                    int i41110 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default10, Z17InlineUtilsKt.asBitmap(str19, color, i4118, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i4119 | (458752 & i41110) | (3670016 & i41110), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i41111 = i33;
                    String str110 = str6;
                    str8 = str110;
                    i34 = i41111;
                    int i41112 = (i15 & 7168) | 100687872;
                    int i41113 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default11, Z17InlineUtilsKt.asBitmap(str110, color, i41111, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i41112 | (458752 & i41113) | (3670016 & i41113), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                }
                if (z17) {
                    composerStartRestartGroup.startReplaceGroup(592293339);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1178554111);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj5;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                map2 = map4;
                colorFilter3 = colorFilter4;
                str4 = str9;
                i30 = i32;
                num2 = num4;
                z13 = z17;
                z14 = z18;
                str3 = str8;
                i31 = i34;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i30 = i10;
                z13 = z10;
                str3 = str2;
                z14 = z11;
                i31 = i11;
                modifier3 = modifier2;
                obj4 = obj3;
                composer2 = composerStartRestartGroup;
                colorFilter3 = colorFilter2;
                str4 = str;
                num2 = num;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj7, Object obj8) {
                        return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                    }
                });
            }
        }
        i15 |= 24576;
        if ((i12 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i14 & 32) == 0) {
                i36 = 65536;
            } else {
                i36 = 65536;
            }
            i15 |= i36;
        }
        i18 = i14 & 128;
        if (i18 != 0) {
            i15 |= 12582912;
        } else if ((i12 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z10)) {
                i19 = 8388608;
            } else {
                i19 = 4194304;
            }
            i15 |= i19;
        }
        i20 = i14 & 256;
        if (i20 != 0) {
            i15 |= 100663296;
        } else if ((i12 & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(map)) {
                i21 = 67108864;
            } else {
                i21 = 33554432;
            }
            i15 |= i21;
        }
        i22 = i14 & 512;
        if (i22 != 0) {
            if ((i12 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i23 = 268435456;
                }
                i15 |= i23;
            }
            i24 = i14 & 1024;
            if (i24 != 0) {
                i25 = i13 | 6;
            } else if ((i13 & 6) == 0) {
                if (composerStartRestartGroup.changed(z11)) {
                    i26 = 4;
                } else {
                    i26 = 2;
                }
                i25 = i13 | i26;
            } else {
                i25 = i13;
            }
            i27 = i14 & 2048;
            if (i27 != 0) {
                i25 |= 48;
            } else if ((i13 & 48) != 0) {
                if (composerStartRestartGroup.changed(i11)) {
                    i28 = 32;
                } else {
                    i28 = 16;
                }
                i25 |= i28;
            }
            i29 = i25;
            if ((i15 & 306259091) == 306259090) {
                z12 = true;
            } else {
                z12 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i12 & 1) != 0) {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                } else {
                    if (i37 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i14 & 4) != 0) {
                        person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                        i15 &= -897;
                    } else {
                        person = obj3;
                    }
                    if (i39 != 0) {
                        colorFilter2 = null;
                    }
                    if (i16 != 0) {
                        str5 = "avatar image";
                    } else {
                        str5 = str;
                    }
                    if ((i14 & 32) != 0) {
                        iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                        i15 = (-458753) & i15;
                    } else {
                        iM5965getHighfv9h1I = i10;
                    }
                    if ((i14 & 64) != 0) {
                        num3 = null;
                    } else {
                        num3 = num;
                    }
                    if (i18 != 0) {
                        z15 = false;
                    } else {
                        z15 = z10;
                    }
                    if (i20 != 0) {
                        map3 = null;
                    } else {
                        map3 = map;
                    }
                    if (i22 != 0) {
                        str6 = "";
                    } else {
                        str6 = str2;
                    }
                    if (i24 != 0) {
                        z16 = false;
                    } else {
                        z16 = z11;
                    }
                    num4 = num3;
                    z17 = z15;
                    i32 = iM5965getHighfv9h1I;
                    colorFilter4 = colorFilter2;
                    z18 = z16;
                    if (i27 != 0) {
                        i33 = 256;
                    } else {
                        i33 = i11;
                    }
                    modifier5 = modifier4;
                    obj5 = person;
                    str7 = str5;
                    map4 = map3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
                }
                Modifier modifierAspectRatio$default7 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default7);
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
                if (obj != null) {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default12 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i41114 = i33;
                    String str111 = str6;
                    str8 = str111;
                    i34 = i41114;
                    int i41115 = (i15 & 7168) | 100687872;
                    int i41116 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default12, Z17InlineUtilsKt.asBitmap(str111, color, i41114, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i41115 | (458752 & i41116) | (3670016 & i41116), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1179971772);
                    Modifier modifierFillMaxSize$default13 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                    if (obj5 instanceof Color) {
                        color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                    } else {
                        color = android.graphics.Color.parseColor("#9c9c9c");
                    }
                    int i41117 = i33;
                    String str112 = str6;
                    str8 = str112;
                    i34 = i41117;
                    int i41118 = (i15 & 7168) | 100687872;
                    int i41119 = i15 << 3;
                    str9 = str7;
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default13, Z17InlineUtilsKt.asBitmap(str112, color, i41117, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i41118 | (458752 & i41119) | (3670016 & i41119), 132);
                    composerStartRestartGroup.endReplaceGroup();
                    obj6 = null;
                    i35 = 1;
                }
                if (z17) {
                    composerStartRestartGroup.startReplaceGroup(592293339);
                    Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1178554111);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj5;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                map2 = map4;
                colorFilter3 = colorFilter4;
                str4 = str9;
                i30 = i32;
                num2 = num4;
                z13 = z17;
                z14 = z18;
                str3 = str8;
                i31 = i34;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i30 = i10;
                z13 = z10;
                str3 = str2;
                z14 = z11;
                i31 = i11;
                modifier3 = modifier2;
                obj4 = obj3;
                composer2 = composerStartRestartGroup;
                colorFilter3 = colorFilter2;
                str4 = str;
                num2 = num;
                map2 = map;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj7, Object obj8) {
                        return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                    }
                });
            }
        }
        i15 |= 805306368;
        i24 = i14 & 1024;
        if (i24 != 0) {
            i25 = i13 | 6;
        } else if ((i13 & 6) == 0) {
            if (composerStartRestartGroup.changed(z11)) {
                i26 = 4;
            } else {
                i26 = 2;
            }
            i25 = i13 | i26;
        } else {
            i25 = i13;
        }
        i27 = i14 & 2048;
        if (i27 != 0) {
            i25 |= 48;
        } else if ((i13 & 48) != 0) {
            if (composerStartRestartGroup.changed(i11)) {
                i28 = 32;
            } else {
                i28 = 16;
            }
            i25 |= i28;
        }
        i29 = i25;
        if ((i15 & 306259091) == 306259090) {
            z12 = true;
        } else {
            z12 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z12, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i12 & 1) != 0) {
                if (i37 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i14 & 4) != 0) {
                    person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                    i15 &= -897;
                } else {
                    person = obj3;
                }
                if (i39 != 0) {
                    colorFilter2 = null;
                }
                if (i16 != 0) {
                    str5 = "avatar image";
                } else {
                    str5 = str;
                }
                if ((i14 & 32) != 0) {
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    i15 = (-458753) & i15;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                if ((i14 & 64) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (i18 != 0) {
                    z15 = false;
                } else {
                    z15 = z10;
                }
                if (i20 != 0) {
                    map3 = null;
                } else {
                    map3 = map;
                }
                if (i22 != 0) {
                    str6 = "";
                } else {
                    str6 = str2;
                }
                if (i24 != 0) {
                    z16 = false;
                } else {
                    z16 = z11;
                }
                num4 = num3;
                z17 = z15;
                i32 = iM5965getHighfv9h1I;
                colorFilter4 = colorFilter2;
                z18 = z16;
                if (i27 != 0) {
                    i33 = 256;
                } else {
                    i33 = i11;
                }
                modifier5 = modifier4;
                obj5 = person;
                str7 = str5;
                map4 = map3;
            } else {
                if (i37 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i14 & 4) != 0) {
                    person = PersonKt.getPerson(Icons.Outlined.INSTANCE);
                    i15 &= -897;
                } else {
                    person = obj3;
                }
                if (i39 != 0) {
                    colorFilter2 = null;
                }
                if (i16 != 0) {
                    str5 = "avatar image";
                } else {
                    str5 = str;
                }
                if ((i14 & 32) != 0) {
                    iM5965getHighfv9h1I = FilterQuality.INSTANCE.m5965getHighfv9h1I();
                    i15 = (-458753) & i15;
                } else {
                    iM5965getHighfv9h1I = i10;
                }
                if ((i14 & 64) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if (i18 != 0) {
                    z15 = false;
                } else {
                    z15 = z10;
                }
                if (i20 != 0) {
                    map3 = null;
                } else {
                    map3 = map;
                }
                if (i22 != 0) {
                    str6 = "";
                } else {
                    str6 = str2;
                }
                if (i24 != 0) {
                    z16 = false;
                } else {
                    z16 = z11;
                }
                num4 = num3;
                z17 = z15;
                i32 = iM5965getHighfv9h1I;
                colorFilter4 = colorFilter2;
                z18 = z16;
                if (i27 != 0) {
                    i33 = 256;
                } else {
                    i33 = i11;
                }
                modifier5 = modifier4;
                obj5 = person;
                str7 = str5;
                map4 = map3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-292953079, i15, i29, "cu.z17.views.picture.Z17PictureAvatar (Z17PictureAvatar.kt:33)");
            }
            Modifier modifierAspectRatio$default8 = AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAspectRatio$default8);
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
            if (obj != null) {
                composerStartRestartGroup.startReplaceGroup(1179971772);
                Modifier modifierFillMaxSize$default14 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                if (obj5 instanceof Color) {
                    color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                } else {
                    color = android.graphics.Color.parseColor("#9c9c9c");
                }
                int i411110 = i33;
                String str113 = str6;
                str8 = str113;
                i34 = i411110;
                int i411111 = (i15 & 7168) | 100687872;
                int i411112 = i15 << 3;
                str9 = str7;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default14, Z17InlineUtilsKt.asBitmap(str113, color, i411110, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i411111 | (458752 & i411112) | (3670016 & i411112), 132);
                composerStartRestartGroup.endReplaceGroup();
                obj6 = null;
                i35 = 1;
            } else {
                composerStartRestartGroup.startReplaceGroup(1179971772);
                Modifier modifierFillMaxSize$default15 = SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null);
                if (obj5 instanceof Color) {
                    color = ColorKt.m5920toArgb8_81llA(((Color) obj5).m5876unboximpl());
                } else {
                    color = android.graphics.Color.parseColor("#9c9c9c");
                }
                int i411113 = i33;
                String str114 = str6;
                str8 = str114;
                i34 = i411113;
                int i411114 = (i15 & 7168) | 100687872;
                int i411115 = i15 << 3;
                str9 = str7;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierFillMaxSize$default15, Z17InlineUtilsKt.asBitmap(str114, color, i411113, i33, true), null, colorFilter4, ContentScale.INSTANCE.getCrop(), str9, i32, null, "", composerStartRestartGroup, i411114 | (458752 & i411115) | (3670016 & i411115), 132);
                composerStartRestartGroup.endReplaceGroup();
                obj6 = null;
                i35 = 1;
            }
            if (z17) {
                composerStartRestartGroup.startReplaceGroup(592293339);
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), 0.0f, i35, obj6), Integer.valueOf(R.drawable.edit_profile_banner), null, null, ContentScale.INSTANCE.getCrop(), "edit profile banner", 0, null, null, composerStartRestartGroup, 221184, 460);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(1178554111);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj4 = obj5;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier5;
            map2 = map4;
            colorFilter3 = colorFilter4;
            str4 = str9;
            i30 = i32;
            num2 = num4;
            z13 = z17;
            z14 = z18;
            str3 = str8;
            i31 = i34;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            i30 = i10;
            z13 = z10;
            str3 = str2;
            z14 = z11;
            i31 = i11;
            modifier3 = modifier2;
            obj4 = obj3;
            composer2 = composerStartRestartGroup;
            colorFilter3 = colorFilter2;
            str4 = str;
            num2 = num;
            map2 = map;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picture.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj7, Object obj8) {
                    return Z17PictureAvatarKt.Z17PictureAvatar_ajT4Zlk$lambda$1(modifier3, obj, obj4, colorFilter3, str4, i30, num2, z13, map2, str3, z14, i31, i12, i13, i14, (Composer) obj7, ((Integer) obj8).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17PictureAvatar_ajT4Zlk$lambda$1(Modifier modifier, Object obj, Object obj2, ColorFilter colorFilter, String str, int i10, Integer num, boolean z10, Map map, String str2, boolean z11, int i11, int i12, int i13, int i14, Composer composer, int i15) {
        m10277Z17PictureAvatarajT4Zlk(modifier, obj, obj2, colorFilter, str, i10, num, z10, map, str2, z11, i11, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1), RecomposeScopeImplKt.updateChangedFlags(i13), i14);
        return k0.f43947a;
    }
}
