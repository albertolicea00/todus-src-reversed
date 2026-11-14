package cu.todus.android.uiCompose.shared.downloadable;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AttachFileKt;
import androidx.compose.material.icons.outlined.AudioFileKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.GifKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material.icons.outlined.StickyNote2Kt;
import androidx.compose.material.icons.outlined.VideocamKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.s3.AttS3State;
import cu.todus.android.s3.S3State;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.o;
import ua.k0;
import ua.r;
import va.g0;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008c\u0001\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001d\u0010\u0015\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aY\u0010 \u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#¨\u0006&²\u0006\u000e\u0010%\u001a\u0004\u0018\u00010$8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "autoDownload", "Lcu/todus/android/uiCompose/shared/downloadable/DownloadableSize;", "size", "", "attachmentId", "folderPath", "", "type", "", "content", "Lcu/todus/android/uiCompose/shared/downloadable/DownloadableViewModel;", "viewModel", "addNotification", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lua/k0;", "Landroidx/compose/runtime/Composable;", "contentInside", "Downloadable", "(Landroidx/compose/ui/Modifier;ZLcu/todus/android/uiCompose/shared/downloadable/DownloadableSize;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Lcu/todus/android/uiCompose/shared/downloadable/DownloadableViewModel;ZLandroid/content/Context;Llb/o;Landroidx/compose/runtime/Composer;III)V", "Lcu/todus/android/s3/AttS3State;", "attS3State", "canCancel", "Lkotlin/Function0;", "download", "cancel", "", "totalSize", "ClickableProgress", "(Lcu/todus/android/s3/AttS3State;ZLlb/a;Llb/a;JLcu/todus/android/uiCompose/shared/downloadable/DownloadableSize;ILandroidx/compose/runtime/Composer;II)V", "contentTypeDownloadIndicator", "(I)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DownloadableKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadableSize.values().length];
            try {
                iArr[DownloadableSize.BIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadableSize.REGULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadableSize.MINI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClickableProgress(final AttS3State attS3State, final boolean z10, final lb.a download, final lb.a cancel, final long j10, DownloadableSize downloadableSize, int i10, Composer composer, final int i11, final int i12) {
        int i13;
        int i14;
        final DownloadableSize downloadableSize2;
        final int i15;
        float fM8823constructorimpl;
        Modifier.Companion companion;
        MaterialTheme materialTheme;
        int i16;
        String strConvertToByteSize;
        long sp;
        float fM8823constructorimpl2;
        float fM8823constructorimpl3;
        y.i(download, "download");
        y.i(cancel, "cancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-911353086);
        if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(attS3State) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(download) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(cancel) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(j10) ? 16384 : 8192;
        }
        int i17 = i12 & 32;
        if (i17 != 0) {
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i13 |= composerStartRestartGroup.changed(downloadableSize == null ? -1 : downloadableSize.ordinal()) ? 131072 : 65536;
        }
        int i18 = i12 & 64;
        if (i18 != 0) {
            i13 |= 1572864;
            i14 = i10;
        } else {
            i14 = i10;
            if ((i11 & 1572864) == 0) {
                i13 |= composerStartRestartGroup.changed(i14) ? 1048576 : 524288;
            }
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 599187) != 599186, i13 & 1)) {
            DownloadableSize downloadableSize3 = i17 != 0 ? DownloadableSize.REGULAR : downloadableSize;
            int i19 = i18 != 0 ? -1 : i14;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-911353086, i13, -1, "cu.todus.android.uiCompose.shared.downloadable.ClickableProgress (Downloadable.kt:170)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            boolean z11 = ((i13 & 896) == 256) | ((i13 & 14) == 4) | ((i13 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.downloadable.h
                    @Override // lb.a
                    public final Object invoke() {
                        return DownloadableKt.ClickableProgress$lambda$0$0(attS3State, cancel, download);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(companion2, false, null, null, null, (lb.a) objRememberedValue, 15, null);
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i20 = MaterialTheme.$stable;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1240clickableoSLSa3U$default, Color.m5865copywmQWz5c$default(materialTheme2.getColorScheme(composerStartRestartGroup, i20).getSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15)));
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i21 = iArr[downloadableSize3.ordinal()];
            if (i21 == 1) {
                fM8823constructorimpl = Dp.m8823constructorimpl(10);
            } else if (i21 == 2) {
                fM8823constructorimpl = Dp.m8823constructorimpl(5);
            } else {
                if (i21 != 3) {
                    throw new r();
                }
                fM8823constructorimpl = Dp.m8823constructorimpl(2);
            }
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifierM1204backgroundbw27NRU, fM8823constructorimpl);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion3.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (objRememberedValue2 == companion5.getEmpty()) {
                int i22 = iArr[downloadableSize3.ordinal()];
                if (i22 == 1) {
                    fM8823constructorimpl3 = Dp.m8823constructorimpl(40);
                } else if (i22 == 2) {
                    fM8823constructorimpl3 = Dp.m8823constructorimpl(30);
                } else {
                    if (i22 != 3) {
                        throw new r();
                    }
                    fM8823constructorimpl3 = Dp.m8823constructorimpl(25);
                }
                objRememberedValue2 = Dp.m8821boximpl(fM8823constructorimpl3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            float fM8837unboximpl = ((Dp) objRememberedValue2).m8837unboximpl();
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion5.getEmpty()) {
                int i23 = iArr[downloadableSize3.ordinal()];
                if (i23 == 1) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(35);
                } else if (i23 == 2) {
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(25);
                } else {
                    if (i23 != 3) {
                        throw new r();
                    }
                    fM8823constructorimpl2 = Dp.m8823constructorimpl(20);
                }
                objRememberedValue3 = Dp.m8821boximpl(fM8823constructorimpl2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            float fM8837unboximpl2 = ((Dp) objRememberedValue3).m8837unboximpl();
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion5.getEmpty()) {
                int i24 = iArr[downloadableSize3.ordinal()];
                if (i24 == 1) {
                    sp = TextUnitKt.getSp(22);
                } else if (i24 == 2) {
                    sp = TextUnitKt.getSp(18);
                } else {
                    if (i24 != 3) {
                        throw new r();
                    }
                    sp = TextUnitKt.getSp(12);
                }
                objRememberedValue4 = TextUnit.m9003boximpl(sp);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            long packedValue = ((TextUnit) objRememberedValue4).getPackedValue();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            lb.a constructor2 = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (attS3State == null) {
                companion = companion2;
                materialTheme = materialTheme2;
                i16 = i20;
            } else if (attS3State.getBytesUsed() == 0.0f) {
                composerStartRestartGroup.startReplaceGroup(849932543);
                companion = companion2;
                i16 = i20;
                materialTheme = materialTheme2;
                Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(SizeKt.m1769size3ABfNKs(companion, fM8837unboximpl), 0.0f, 0.0f, materialTheme2.getColorScheme(composerStartRestartGroup, i20).getOnBackground(), composerStartRestartGroup, 6, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                companion = companion2;
                materialTheme = materialTheme2;
                i16 = i20;
                composerStartRestartGroup.startReplaceGroup(850208629);
                Z17SimpleCircleLoaderKt.m10264Z17CircleProgressLoadergZXFtk(SizeKt.m1769size3ABfNKs(companion, fM8837unboximpl), attS3State.getBytesUsed() / attS3State.getBytesTotal(), Dp.m8823constructorimpl(3), 0.0f, materialTheme.getColorScheme(composerStartRestartGroup, i16).getOnBackground(), composerStartRestartGroup, 390, 8);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z10) {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(850624432);
                Composer composer2 = composerStartRestartGroup;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(companion, fM8837unboximpl2), attS3State != null ? CloseKt.getClose(Icons.Outlined.INSTANCE) : contentTypeDownloadIndicator(i19), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composerStartRestartGroup, i16).getBackground(), 0, 2, null), null, attS3State != null ? "cancel btn" : "download btn", 0, null, null, composer2, 6, 468);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(851060726);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (attS3State == null || attS3State.getBytesUsed() > 0) {
                composerStartRestartGroup.startReplaceGroup(14123593);
                TextStyle textStyleM8271copyp1EtxEg$default = TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i16).getBodySmall(), 0L, packedValue, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
                if (j10 < 0) {
                    strConvertToByteSize = "--";
                } else {
                    strConvertToByteSize = NumberInlineFunctionsKt.convertToByteSize(j10 - (attS3State != null ? attS3State.getBytesUsed() : 0L));
                }
                Composer composer3 = composerStartRestartGroup;
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, strConvertToByteSize, textStyleM8271copyp1EtxEg$default, materialTheme.getColorScheme(composerStartRestartGroup, i16).getBackground(), 0, 0, composer3, 0, 49);
                composerStartRestartGroup = composer3;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(14418620);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            downloadableSize2 = downloadableSize3;
            i15 = i19;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            downloadableSize2 = downloadableSize;
            i15 = i14;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.downloadable.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DownloadableKt.ClickableProgress$lambda$2(attS3State, z10, download, cancel, j10, downloadableSize2, i15, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ClickableProgress$lambda$0$0(AttS3State attS3State, lb.a aVar, lb.a aVar2) {
        if (attS3State != null) {
            aVar.invoke();
        } else {
            aVar2.invoke();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ClickableProgress$lambda$2(AttS3State attS3State, boolean z10, lb.a aVar, lb.a aVar2, long j10, DownloadableSize downloadableSize, int i10, int i11, int i12, Composer composer, int i13) {
        ClickableProgress(attS3State, z10, aVar, aVar2, j10, downloadableSize, i10, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:181:0x0354  */
    /* JADX WARN: Code duplicated, block: B:219:0x044f  */
    /* JADX WARN: Code duplicated, block: B:222:0x0487  */
    /* JADX WARN: Code duplicated, block: B:225:0x049b  */
    /* JADX WARN: Code duplicated, block: B:228:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:229:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:234:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:237:0x04e5  */
    @Composable
    public static final void Downloadable(Modifier modifier, boolean z10, DownloadableSize downloadableSize, String str, final String folderPath, int i10, final Object content, DownloadableViewModel downloadableViewModel, boolean z11, Context context, final o contentInside, Composer composer, final int i11, final int i12, final int i13) {
        Modifier modifier2;
        int i14;
        DownloadableViewModel downloadableViewModel2;
        final Context context2;
        int i15;
        final boolean z12;
        final DownloadableSize downloadableSize2;
        final int i16;
        final boolean z13;
        final Modifier modifier3;
        final DownloadableViewModel downloadableViewModel3;
        boolean z14;
        int i17;
        boolean z15;
        Context context3;
        final DownloadableViewModel downloadableViewModel4;
        DownloadableSize downloadableSize3;
        int i18;
        Modifier modifier4;
        int i19;
        boolean z16;
        Object next;
        boolean z17;
        DownloadableSize downloadableSize4;
        int i20;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        Object objRememberedValue3;
        DownloadableViewModel downloadableViewModel5;
        boolean z18;
        boolean zChangedInstance;
        Object objRememberedValue4;
        AttS3State attS3State;
        List<AttS3State> attList;
        Object next2;
        String attachmentId = str;
        y.i(attachmentId, "attachmentId");
        y.i(folderPath, "folderPath");
        y.i(content, "content");
        y.i(contentInside, "contentInside");
        Composer composerStartRestartGroup = composer.startRestartGroup(-340955046);
        int i21 = i13 & 1;
        if (i21 != 0) {
            i14 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i14 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i14 = i11;
        }
        int i22 = i13 & 2;
        if (i22 != 0) {
            i14 |= 48;
        } else if ((i11 & 48) == 0) {
            i14 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        int i23 = i13 & 4;
        if (i23 != 0) {
            i14 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i14 |= composerStartRestartGroup.changed(downloadableSize == null ? -1 : downloadableSize.ordinal()) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i14 |= composerStartRestartGroup.changed(attachmentId) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i14 |= composerStartRestartGroup.changed(folderPath) ? 16384 : 8192;
        }
        int i24 = i13 & 32;
        if (i24 != 0) {
            i14 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i11 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i14 |= composerStartRestartGroup.changedInstance(content) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            if ((i13 & 128) == 0) {
                downloadableViewModel2 = downloadableViewModel;
                int i25 = composerStartRestartGroup.changedInstance(downloadableViewModel2) ? 8388608 : 4194304;
                i14 |= i25;
            } else {
                downloadableViewModel2 = downloadableViewModel;
            }
            i14 |= i25;
        } else {
            downloadableViewModel2 = downloadableViewModel;
        }
        if ((i11 & 805306368) == 0) {
            if ((i13 & 512) == 0) {
                context2 = context;
                int i26 = composerStartRestartGroup.changedInstance(context2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                i14 |= i26;
            } else {
                context2 = context;
            }
            i14 |= i26;
        } else {
            context2 = context;
        }
        int i27 = i14;
        if ((i12 & 6) == 0) {
            i15 = i12 | (composerStartRestartGroup.changedInstance(contentInside) ? 4 : 2);
        } else {
            i15 = i12;
        }
        if (composerStartRestartGroup.shouldExecute(((i27 & 273228947) == 273228946 && (i15 & 3) == 2) ? false : true, i27 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i11 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i21 != 0 ? Modifier.INSTANCE : modifier2;
                boolean z19 = i22 != 0 ? false : z10;
                DownloadableSize downloadableSize5 = i23 != 0 ? DownloadableSize.REGULAR : downloadableSize;
                int i28 = i24 == 0 ? i10 : -1;
                if ((i13 & 128) != 0) {
                    DownloadableViewModelFactory downloadableViewModelFactory = new DownloadableViewModelFactory(attachmentId, folderPath);
                    int i29 = (i27 >> 6) & 112;
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i17 = -340955046;
                    i27 &= -29360129;
                    i15 = i15;
                    downloadableViewModel2 = (DownloadableViewModel) ViewModelKt.viewModel(z0.b(DownloadableViewModel.class), current, attachmentId, downloadableViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, (i29 << 3) & 896, 0);
                    z14 = false;
                } else {
                    z14 = false;
                    i17 = -340955046;
                }
                z15 = (i13 & 256) != 0 ? z14 : z11;
                if ((i13 & 512) != 0) {
                    i27 &= -1879048193;
                    context3 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                } else {
                    context3 = context2;
                }
                downloadableViewModel4 = downloadableViewModel2;
                downloadableSize3 = downloadableSize5;
                i18 = i28;
                modifier4 = modifier5;
                i19 = i27;
                z16 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i13 & 128) != 0) {
                    i27 &= -29360129;
                }
                if ((i13 & 512) != 0) {
                    i27 &= -1879048193;
                }
                downloadableSize3 = downloadableSize;
                z15 = z11;
                context3 = context2;
                downloadableViewModel4 = downloadableViewModel2;
                i17 = -340955046;
                z16 = z10;
                attachmentId = attachmentId;
                modifier4 = modifier2;
                i19 = i27;
                i18 = i10;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i17, i19, i15, "cu.todus.android.uiCompose.shared.downloadable.Downloadable (Downloadable.kt:74)");
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            DownloadableSize downloadableSize6 = downloadableSize3;
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            int i30 = i18;
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            int i31 = i19;
            lb.a constructor = companion2.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            int i32 = i15;
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, v.e(PermissionNeedIt.STORAGE), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState = (MutableState) objRememberedValue5;
            Iterator it = ((Iterable) FlowExtKt.collectAsStateWithLifecycle(downloadableViewModel4.getDownloadState(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14).getValue()).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!y.d(((S3State) next).getItemId(), attachmentId));
            S3State s3State = (S3State) next;
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(downloadableViewModel4.getAttachment(), (Object) null, (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            if (s3State == null) {
                List listQ = w.q(2, 6);
                Attachment attachmentDownloadable$lambda$0$2 = Downloadable$lambda$0$2(stateCollectAsStateWithLifecycle);
                if (g0.j0(listQ, attachmentDownloadable$lambda$0$2 != null ? Integer.valueOf(attachmentDownloadable$lambda$0$2.getState()) : null)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } else {
                z17 = false;
            }
            contentInside.invoke(content, Boolean.valueOf(z17), composerStartRestartGroup, Integer.valueOf(((i31 >> 18) & 14) | ((i32 << 6) & 896)));
            if (Downloadable$lambda$0$2(stateCollectAsStateWithLifecycle) != null) {
                List listQ2 = w.q(2, 6);
                Attachment attachmentDownloadable$lambda$0$3 = Downloadable$lambda$0$2(stateCollectAsStateWithLifecycle);
                if (!g0.j0(listQ2, attachmentDownloadable$lambda$0$3 != null ? Integer.valueOf(attachmentDownloadable$lambda$0$3.getState()) : null)) {
                    composerStartRestartGroup.startReplaceGroup(448980584);
                    if (s3State == null || (attList = s3State.getAttList()) == null) {
                        attS3State = null;
                    } else {
                        Iterator<T> it2 = attList.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it2.next();
                        } while (!y.d(((AttS3State) next2).getSubItemId(), attachmentId));
                        attS3State = (AttS3State) next2;
                    }
                    long size = ((FileContent) content).getSize();
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(downloadableViewModel4);
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.downloadable.b
                            @Override // lb.a
                            public final Object invoke() {
                                return DownloadableKt.Downloadable$lambda$0$4$0(mutableState, downloadableViewModel4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    lb.a aVar = (lb.a) objRememberedValue6;
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(downloadableViewModel4);
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.downloadable.c
                            @Override // lb.a
                            public final Object invoke() {
                                return DownloadableKt.Downloadable$lambda$0$5$0(downloadableViewModel4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ClickableProgress(attS3State, true, aVar, (lb.a) objRememberedValue7, size, downloadableSize6, i30, composerStartRestartGroup, ((i31 << 9) & 458752) | 48 | ((i31 << 3) & 3670016), 0);
                    downloadableSize4 = downloadableSize6;
                    i20 = i30;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.downloadable.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DownloadableKt.Downloadable$lambda$0$6$0(mutableState, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Z17PermissionRequesterKt.Z17PermissionChecker(null, null, permissionsRequesterState, (Function1) objRememberedValue, ComposableSingletons$DownloadableKt.INSTANCE.getLambda$683997824$app_productionPFast(), composerStartRestartGroup, 27648, 3);
                PermissionsRequesterState permissionsRequesterState2 = (PermissionsRequesterState) mutableState.getValue();
                String packageName = context3.getPackageName();
                y.h(packageName, "getPackageName(...)");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.downloadable.e
                        @Override // lb.a
                        public final Object invoke() {
                            return DownloadableKt.Downloadable$lambda$0$7$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                lb.a aVar2 = (lb.a) objRememberedValue2;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.shared.downloadable.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DownloadableKt.Downloadable$lambda$0$8$0(mutableState, (PermissionsResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                downloadableViewModel5 = downloadableViewModel4;
                Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState2, aVar2, (Function1) objRememberedValue3, packageName, composerStartRestartGroup, 432);
                k0 k0Var = k0.f43947a;
                if ((i31 & 112) == 32) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                zChangedInstance = z18 | composerStartRestartGroup.changedInstance(downloadableViewModel5);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new DownloadableKt$Downloadable$1$7$1(z16, downloadableViewModel5, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue4, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                downloadableViewModel3 = downloadableViewModel5;
                modifier3 = modifier4;
                downloadableSize2 = downloadableSize4;
                z12 = z16;
                i16 = i20;
                z13 = z15;
                context2 = context3;
            }
            downloadableSize4 = downloadableSize6;
            i20 = i30;
            composerStartRestartGroup.startReplaceGroup(449569026);
            composerStartRestartGroup.endReplaceGroup();
            PermissionsRequesterState permissionsRequesterState3 = (PermissionsRequesterState) mutableState.getValue();
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.shared.downloadable.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DownloadableKt.Downloadable$lambda$0$6$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, null, permissionsRequesterState3, (Function1) objRememberedValue, ComposableSingletons$DownloadableKt.INSTANCE.getLambda$683997824$app_productionPFast(), composerStartRestartGroup, 27648, 3);
            PermissionsRequesterState permissionsRequesterState4 = (PermissionsRequesterState) mutableState.getValue();
            String packageName2 = context3.getPackageName();
            y.h(packageName2, "getPackageName(...)");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.downloadable.e
                    @Override // lb.a
                    public final Object invoke() {
                        return DownloadableKt.Downloadable$lambda$0$7$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            lb.a aVar3 = (lb.a) objRememberedValue2;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.shared.downloadable.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DownloadableKt.Downloadable$lambda$0$8$0(mutableState, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            downloadableViewModel5 = downloadableViewModel4;
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterState4, aVar3, (Function1) objRememberedValue3, packageName2, composerStartRestartGroup, 432);
            k0 k0Var2 = k0.f43947a;
            if ((i31 & 112) == 32) {
                z18 = true;
            } else {
                z18 = false;
            }
            zChangedInstance = z18 | composerStartRestartGroup.changedInstance(downloadableViewModel5);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue4 = new DownloadableKt$Downloadable$1$7$1(z16, downloadableViewModel5, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new DownloadableKt$Downloadable$1$7$1(z16, downloadableViewModel5, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(k0Var2, (Function2) objRememberedValue4, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            downloadableViewModel3 = downloadableViewModel5;
            modifier3 = modifier4;
            downloadableSize2 = downloadableSize4;
            z12 = z16;
            i16 = i20;
            z13 = z15;
            context2 = context3;
        } else {
            attachmentId = attachmentId;
            composerStartRestartGroup.skipToGroupEnd();
            z12 = z10;
            downloadableSize2 = downloadableSize;
            i16 = i10;
            z13 = z11;
            modifier3 = modifier2;
            downloadableViewModel3 = downloadableViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = attachmentId;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.downloadable.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DownloadableKt.Downloadable$lambda$1(modifier3, z12, downloadableSize2, str2, folderPath, i16, content, downloadableViewModel3, z13, context2, contentInside, i11, i12, i13, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Attachment Downloadable$lambda$0$2(State<Attachment> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$0$4$0(MutableState mutableState, DownloadableViewModel downloadableViewModel) {
        Integer state = ((PermissionsRequesterState) mutableState.getValue()).getPermissionsResult().getState();
        if (state != null && state.intValue() == 2) {
            downloadableViewModel.download();
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, true, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$0$5$0(DownloadableViewModel downloadableViewModel) {
        downloadableViewModel.cancelDownload();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$0$6$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) mutableState.getValue();
        Integer state = result.getState();
        mutableState.setValue(PermissionsRequesterState.copy$default(permissionsRequesterState, result, state == null || state.intValue() != 2, null, 4, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$0$7$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$0$8$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default((PermissionsRequesterState) mutableState.getValue(), null, false, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Downloadable$lambda$1(Modifier modifier, boolean z10, DownloadableSize downloadableSize, String str, String str2, int i10, Object obj, DownloadableViewModel downloadableViewModel, boolean z11, Context context, o oVar, int i11, int i12, int i13, Composer composer, int i14) {
        Downloadable(modifier, z10, downloadableSize, str, str2, i10, obj, downloadableViewModel, z11, context, oVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), RecomposeScopeImplKt.updateChangedFlags(i12), i13);
        return k0.f43947a;
    }

    private static final Object contentTypeDownloadIndicator(int i10) {
        if (i10 == 1) {
            return ImageKt.getImage(Icons.Outlined.INSTANCE);
        }
        if (i10 == 2) {
            return VideocamKt.getVideocam(Icons.Outlined.INSTANCE);
        }
        if (i10 == 3) {
            return AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE);
        }
        if (i10 == 4) {
            return Integer.valueOf(R.drawable.mic_icon);
        }
        if (i10 != 7) {
            return i10 != 13 ? AttachFileKt.getAttachFile(Icons.Outlined.INSTANCE) : StickyNote2Kt.getStickyNote2(Icons.Outlined.INSTANCE);
        }
        return GifKt.getGif(Icons.Outlined.INSTANCE);
    }
}
