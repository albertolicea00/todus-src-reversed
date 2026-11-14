package cu.todus.android.uiCompose.main.screen.chat.presend;

import ab.j;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.os.BundleKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.constants.Service;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.uiCompose.shared.uploadable.UploadableKt;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.l;
import defpackage.r;
import java.io.File;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import lb.o;
import le.d0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import pe.a2;
import pe.d1;
import pe.k;
import pe.m0;
import ua.k0;
import ua.z;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a?\u0010\b\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\r\u001a\u00020\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011²\u0006\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"", "Landroid/net/Uri;", Service.Endpoint.LINKED_DEVICES_LIST, "Lkotlin/Function1;", "Lua/k0;", "removeItem", "Lkotlin/Function0;", "add", "PresentList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "getAttachedFilesAndType", "(Ljava/util/List;Landroid/content/Context;)Landroid/os/Bundle;", "", "thumbnailPath", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PresentListKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PresentList(final List<? extends Uri> list, final Function1 removeItem, final lb.a add, Composer composer, final int i10) {
        int i11;
        Composer composer2;
        y.i(list, "list");
        y.i(removeItem, "removeItem");
        y.i(add, "add");
        Composer composerStartRestartGroup = composer.startRestartGroup(1247864157);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(removeItem) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(add) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 147) != 146, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1247864157, i11, -1, "cu.todus.android.uiCompose.main.screen.chat.presend.PresentList (PresentList.kt:66)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(BackgroundKt.m1205backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null), Dp.m8823constructorimpl(80));
            GridCells.Fixed fixed = new GridCells.Fixed(1);
            boolean zChangedInstance = ((i11 & 112) == 32) | composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changedInstance(context) | ((i11 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PresentListKt.PresentList$lambda$0$0(list, context, removeItem, add, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composer2 = composerStartRestartGroup;
            LazyGridDslKt.LazyHorizontalGrid(fixed, modifierM1755height3ABfNKs, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PresentListKt.PresentList$lambda$1(list, removeItem, add, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentList$lambda$0$0(final List list, final Context context, final Function1 function1, final lb.a aVar, LazyGridScope LazyHorizontalGrid) {
        y.i(LazyHorizontalGrid, "$this$LazyHorizontalGrid");
        final Function1 function2 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresentListKt.PresentList$lambda$0$0$0((Uri) obj);
            }
        };
        final PresentListKt$PresentList$lambda$0$0$$inlined$items$default$1 presentListKt$PresentList$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Uri uri) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Uri) obj);
            }
        };
        LazyHorizontalGrid.items(list.size(), new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return function2.invoke(list.get(i10));
            }
        }, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i10) {
                return presentListKt$PresentList$lambda$0$0$$inlined$items$default$1.invoke(list.get(i10));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new o() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$lambda$0$0$$inlined$items$default$5
            @Override // lb.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return k0.f43947a;
            }

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
            @Composable
            public final void invoke(LazyGridItemScope lazyGridItemScope, int i10, Composer composer, int i11) {
                int i12;
                int i13;
                MutableState mutableState;
                float f10;
                Modifier.Companion companion;
                MaterialTheme materialTheme;
                final Uri uri;
                m0 m0Var;
                int i14;
                Composer composer2 = composer;
                if ((i11 & 6) == 0) {
                    i12 = i11 | (composer2.changed(lazyGridItemScope) ? 4 : 2);
                } else {
                    i12 = i11;
                }
                if ((i11 & 48) == 0) {
                    i12 |= composer2.changed(i10) ? 32 : 16;
                }
                if (!composer2.shouldExecute((i12 & 147) != 146, i12 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, i12, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                final Uri uri2 = (Uri) list.get(i10);
                composer2.startReplaceGroup(208198563);
                String path = MediaUtil.INSTANCE.getPath(context, uri2);
                if (path == null) {
                    path = "";
                }
                Object objRememberedValue = composer2.rememberedValue();
                Composer.Companion companion2 = Composer.INSTANCE;
                if (objRememberedValue == companion2.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue;
                if (d0.q0(path)) {
                    composer2.startReplaceGroup(221003887);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(208381152);
                    File file = new File(path);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    float f11 = 2;
                    Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(f11));
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                    int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    lb.a constructor = companion5.getConstructor();
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
                    Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion5.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl, companion5.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    if (file.exists()) {
                        composer2.startReplaceGroup(893200842);
                        if (ExtensionFunsKt.isVideo(file)) {
                            composer2.startReplaceGroup(892994010);
                            Object objRememberedValue2 = composer2.rememberedValue();
                            if (objRememberedValue2 == companion2.getEmpty()) {
                                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(j.f643c, composer2);
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            m0 m0Var2 = (m0) objRememberedValue2;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(AspectRatioKt.aspectRatio$default(companion3, 1.0f, false, 2, null), 0.0f, 1, null);
                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                            int i15 = MaterialTheme.$stable;
                            Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, materialTheme2.getColorScheme(composer2, i15).getOnBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
                            lb.a constructor2 = companion5.getConstructor();
                            if (!r.a(composer2.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                            String strPresentList$lambda$0$0$1$1 = PresentListKt.PresentList$lambda$0$0$1$1(mutableState2);
                            if (strPresentList$lambda$0$0$1$1 == null) {
                                composer2.startReplaceGroup(-1968183348);
                                composer2.endReplaceGroup();
                                uri = uri2;
                                companion = companion3;
                                mutableState = mutableState2;
                                f10 = f11;
                                m0Var = m0Var2;
                                materialTheme = materialTheme2;
                                i13 = i15;
                                i14 = 24;
                            } else {
                                composer2.startReplaceGroup(-1968183347);
                                i13 = i15;
                                mutableState = mutableState2;
                                f10 = f11;
                                companion = companion3;
                                materialTheme = materialTheme2;
                                uri = uri2;
                                m0Var = m0Var2;
                                i14 = 24;
                                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Uri.fromFile(new File(strPresentList$lambda$0$0$1$1)), null, null, ContentScale.INSTANCE.getFillBounds(), null, 0, null, null, composer2, 24582, 492);
                                k0 k0Var = k0.f43947a;
                                composer2.endReplaceGroup();
                            }
                            boolean zChanged = composer2.changed(function1) | composer2.changedInstance(uri);
                            Object objRememberedValue3 = composer2.rememberedValue();
                            if (zChanged || objRememberedValue3 == companion2.getEmpty()) {
                                final Function1 function3 = function1;
                                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$1$2$1
                                    @Override // lb.a
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m9902invoke();
                                        return k0.f43947a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m9902invoke() {
                                        function3.invoke(uri);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue3);
                            }
                            float f12 = i14;
                            int i16 = i13;
                            IconKt.m3298Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), "cancel btn", boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion, false, null, null, null, (lb.a) objRememberedValue3, 15, null), Dp.m8823constructorimpl(f12)), Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composer2, i16).getSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f10)), companion4.getTopEnd()), materialTheme.getColorScheme(composer2, i16).getOnBackground(), composer2, 48, 0);
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BackgroundKt.m1204backgroundbw27NRU(boxScopeInstance.align(SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(f12)), companion4.getCenter()), materialTheme.getColorScheme(composer2, i16).getSurface(), RoundedCornerShapeKt.getCircleShape()), UploadableKt.contentTypeUploadIndicator(2), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer2, i16).getOnBackground(), 0, 2, null), null, "video type", 0, null, null, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 468);
                            k0 k0Var2 = k0.f43947a;
                            final m0 m0Var3 = m0Var;
                            boolean zChangedInstance = composer2.changedInstance(m0Var3) | composer2.changedInstance(uri);
                            Object objRememberedValue4 = composer2.rememberedValue();
                            if (zChangedInstance || objRememberedValue4 == companion2.getEmpty()) {
                                final MutableState mutableState3 = mutableState;
                                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$1$3$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                        y.i(DisposableEffect, "$this$DisposableEffect");
                                        final a2 a2VarD = k.d(m0Var3, d1.b(), null, new PresentListKt$PresentList$1$1$2$1$1$3$1$job$1(uri, mutableState3, null), 2, null);
                                        return new DisposableEffectResult() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$1$3$1$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                                a2.a.a(a2VarD, null, 1, null);
                                            }
                                        };
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue4);
                            }
                            EffectsKt.DisposableEffect(k0Var2, (Function1) objRememberedValue4, composer2, 6);
                            composer2.endNode();
                            composer2.endReplaceGroup();
                        } else if (ExtensionFunsKt.isAudio(file)) {
                            composer2.startReplaceGroup(896737539);
                            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(companion3, 1.0f, false, 2, null);
                            MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                            int i17 = MaterialTheme.$stable;
                            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(BackgroundKt.m1204backgroundbw27NRU(modifierAspectRatio$default, Color.m5865copywmQWz5c$default(materialTheme3.getColorScheme(composer2, i17).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), 0.0f, 1, null), Dp.m8823constructorimpl(f11));
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                            int iA3 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs2);
                            lb.a constructor3 = companion5.getConstructor();
                            if (!r.a(composer2.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composer2);
                            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion5.getSetModifier());
                            boolean zChanged2 = composer2.changed(function1) | composer2.changedInstance(uri2);
                            Object objRememberedValue5 = composer2.rememberedValue();
                            if (zChanged2 || objRememberedValue5 == companion2.getEmpty()) {
                                final Function1 function4 = function1;
                                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$2$1$1
                                    @Override // lb.a
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m9903invoke();
                                        return k0.f43947a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m9903invoke() {
                                        function4.invoke(uri2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue5);
                            }
                            float f13 = 24;
                            IconKt.m3298Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), "cancel btn", boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue5, 15, null), Dp.m8823constructorimpl(f13)), materialTheme3.getColorScheme(composer2, i17).getSurface(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f11)), companion4.getTopEnd()), materialTheme3.getColorScheme(composer2, i17).getOnBackground(), composer2, 48, 0);
                            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(boxScopeInstance.align(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(f13)), companion4.getCenter()), materialTheme3.getColorScheme(composer2, i17).getSurface(), RoundedCornerShapeKt.getCircleShape());
                            Object objContentTypeUploadIndicator = UploadableKt.contentTypeUploadIndicator(3);
                            ColorFilter colorFilterM5907tintxETnrds$default = ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme3.getColorScheme(composer2, i17).getOnBackground(), 0, 2, null);
                            composer2 = composer;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1204backgroundbw27NRU, objContentTypeUploadIndicator, null, colorFilterM5907tintxETnrds$default, null, "audio type", 0, null, null, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 468);
                            composer2.endNode();
                            composer2.endReplaceGroup();
                        } else if (ExtensionFunsKt.isImage(file)) {
                            composer2.startReplaceGroup(899244788);
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(AspectRatioKt.aspectRatio$default(companion3, 1.0f, false, 2, null), 0.0f, 1, null);
                            MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                            int i18 = MaterialTheme.$stable;
                            Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default2, materialTheme4.getColorScheme(composer2, i18).getOnBackground(), null, 2, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                            int iA4 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default2);
                            lb.a constructor4 = companion5.getConstructor();
                            if (!r.a(composer2.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor4);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composer2);
                            Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion5.getSetModifier());
                            composer2 = composer;
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), Uri.fromFile(file), null, null, ContentScale.INSTANCE.getFit(), null, 0, null, null, composer2, 24582, 492);
                            boolean zChanged3 = composer2.changed(function1) | composer2.changedInstance(uri2);
                            Object objRememberedValue6 = composer2.rememberedValue();
                            if (zChanged3 || objRememberedValue6 == companion2.getEmpty()) {
                                final Function1 function5 = function1;
                                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$3$1$1
                                    @Override // lb.a
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m9904invoke();
                                        return k0.f43947a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m9904invoke() {
                                        function5.invoke(uri2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            }
                            float f14 = 24;
                            IconKt.m3298Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), "cancel btn", boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue6, 15, null), Dp.m8823constructorimpl(f14)), materialTheme4.getColorScheme(composer2, i18).getSurface(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f11)), companion4.getTopEnd()), materialTheme4.getColorScheme(composer2, i18).getOnBackground(), composer2, 48, 0);
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BackgroundKt.m1204backgroundbw27NRU(boxScopeInstance.align(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(f14)), companion4.getCenter()), materialTheme4.getColorScheme(composer2, i18).getSurface(), RoundedCornerShapeKt.getCircleShape()), UploadableKt.contentTypeUploadIndicator(1), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme4.getColorScheme(composer2, i18).getOnBackground(), 0, 2, null), null, "img type", 0, null, null, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 468);
                            composer2.endNode();
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(901859886);
                            Arrangement arrangement = Arrangement.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion4.getTop(), composer2, 0);
                            int iA5 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, companion3);
                            lb.a constructor5 = companion5.getConstructor();
                            if (!r.a(composer2.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor5);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5176constructorimpl5 = Updater.m5176constructorimpl(composer2);
                            Updater.m5184setimpl(composerM5176constructorimpl5, measurePolicyRowMeasurePolicy, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl5, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl5, Integer.valueOf(iA5), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl5, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl5, modifierMaterializeModifier5, companion5.getSetModifier());
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            Modifier modifierAspectRatio$default2 = AspectRatioKt.aspectRatio$default(companion3, 1.0f, false, 2, null);
                            MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                            int i19 = MaterialTheme.$stable;
                            float f15 = 15;
                            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(BackgroundKt.m1204backgroundbw27NRU(modifierAspectRatio$default2, Color.m5865copywmQWz5c$default(materialTheme5.getColorScheme(composer2, i19).getPrimary(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2016RoundedCornerShapea9UjIt4(Dp.m8823constructorimpl(30), Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f15), Dp.m8823constructorimpl(f15))), 0.0f, 1, null);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                            int iA6 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default3);
                            lb.a constructor6 = companion5.getConstructor();
                            if (!r.a(composer2.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor6);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5176constructorimpl6 = Updater.m5176constructorimpl(composer2);
                            Updater.m5184setimpl(composerM5176constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl6, currentCompositionLocalMap6, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl6, Integer.valueOf(iA6), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl6, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl6, modifierMaterializeModifier6, companion5.getSetModifier());
                            boolean zChanged4 = composer2.changed(function1) | composer2.changedInstance(uri2);
                            Object objRememberedValue7 = composer2.rememberedValue();
                            if (zChanged4 || objRememberedValue7 == companion2.getEmpty()) {
                                final Function1 function6 = function1;
                                objRememberedValue7 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.PresentListKt$PresentList$1$1$2$1$4$1$1$1
                                    @Override // lb.a
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m9905invoke();
                                        return k0.f43947a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m9905invoke() {
                                        function6.invoke(uri2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            float f16 = 24;
                            IconKt.m3298Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), "cancel btn", boxScopeInstance.align(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(SizeKt.m1769size3ABfNKs(ClickableKt.m1240clickableoSLSa3U$default(companion3, false, null, null, null, (lb.a) objRememberedValue7, 15, null), Dp.m8823constructorimpl(f16)), materialTheme5.getColorScheme(composer2, i19).getSurface(), RoundedCornerShapeKt.getCircleShape()), Dp.m8823constructorimpl(f11)), companion4.getTopEnd()), materialTheme5.getColorScheme(composer2, i19).getOnBackground(), composer2, 48, 0);
                            Z17PictureKt.m10278Z17BasePictureC8z9wKI(BackgroundKt.m1204backgroundbw27NRU(boxScopeInstance.align(SizeKt.m1769size3ABfNKs(companion3, Dp.m8823constructorimpl(f16)), companion4.getCenter()), materialTheme5.getColorScheme(composer2, i19).getSurface(), RoundedCornerShapeKt.getCircleShape()), UploadableKt.contentTypeUploadIndicator(5), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme5.getColorScheme(composer2, i19).getOnBackground(), 0, 2, null), null, "file type", 0, null, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 468);
                            composer.endNode();
                            Modifier modifierM1774width3ABfNKs = SizeKt.m1774width3ABfNKs(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(140));
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion4.getStart(), composer, 6);
                            int iA7 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifierM1774width3ABfNKs);
                            lb.a constructor7 = companion5.getConstructor();
                            if (!r.a(composer.getApplier())) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor7);
                            } else {
                                composer.useNode();
                            }
                            Composer composerM5176constructorimpl7 = Updater.m5176constructorimpl(composer);
                            Updater.m5184setimpl(composerM5176constructorimpl7, measurePolicyColumnMeasurePolicy, companion5.getSetMeasurePolicy());
                            Updater.m5184setimpl(composerM5176constructorimpl7, currentCompositionLocalMap7, companion5.getSetResolvedCompositionLocals());
                            Updater.m5180initimpl(composerM5176constructorimpl7, Integer.valueOf(iA7), companion5.getSetCompositeKeyHash());
                            Updater.m5182reconcileimpl(composerM5176constructorimpl7, companion5.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5184setimpl(composerM5176constructorimpl7, modifierMaterializeModifier7, companion5.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            String name = file.getName();
                            y.h(name, "getName(...)");
                            Z17LabelKt.m10262Z17LabelfWhpE4E(null, name, null, 0L, 2, 0, composer, 24576, 45);
                            Z17LabelKt.m10262Z17LabelfWhpE4E(null, NumberInlineFunctionsKt.convertToByteSize(file.length()), materialTheme5.getTypography(composer, i19).getLabelSmall(), 0L, 0, 0, composer, 0, 57);
                            composer2 = composer;
                            composer2.endNode();
                            composer2.endNode();
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(905661168);
                        composer2.endReplaceGroup();
                    }
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (list.size() < 5) {
            LazyGridScope.CC.a(LazyHorizontalGrid, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1586804260, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PresentListKt.PresentList$lambda$0$0$2(aVar, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 7, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object PresentList$lambda$0$0$0(Uri it) {
        y.i(it, "it");
        String path = it.getPath();
        if (path != null) {
            return path;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        y.h(uuidRandomUUID, "randomUUID(...)");
        return uuidRandomUUID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PresentList$lambda$0$0$1$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 PresentList$lambda$0$0$2(final lb.a aVar, LazyGridItemScope item, Composer composer, int i10) {
        y.i(item, "$this$item");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586804260, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.presend.PresentList.<anonymous>.<anonymous>.<anonymous> (PresentList.kt:322)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(100));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1769size3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion3.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ImageVector add = AddKt.getAdd(Icons.Outlined.INSTANCE);
            Modifier modifierM1769size3ABfNKs2 = SizeKt.m1769size3ABfNKs(boxScopeInstance.align(companion, companion2.getCenter()), Dp.m8823constructorimpl(40));
            boolean zChanged = composer.changed(aVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.presend.c
                    @Override // lb.a
                    public final Object invoke() {
                        return PresentListKt.PresentList$lambda$0$0$2$0$0$0(aVar);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(ClickableKt.m1240clickableoSLSa3U$default(modifierM1769size3ABfNKs2, false, null, null, null, (lb.a) objRememberedValue, 15, null), add, null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentList$lambda$0$0$2$0$0$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PresentList$lambda$1(List list, Function1 function1, lb.a aVar, int i10, Composer composer, int i11) {
        PresentList(list, function1, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005b A[PHI: r6
      0x005b: PHI (r6v10 int) = (r6v8 int), (r6v11 int) binds: [B:30:0x0061, B:25:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    public static final Bundle getAttachedFilesAndType(List<? extends Uri> list, Context context) {
        int i10;
        y.i(list, "list");
        y.i(context, "context");
        int i11 = -1;
        boolean z10 = true;
        int i12 = 0;
        for (Object obj : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                w.x();
            }
            String path = MediaUtil.INSTANCE.getPath(context, (Uri) obj);
            if (path == null) {
                path = "";
            }
            if (d0.q0(path)) {
                i11 = -1;
                z10 = false;
            } else {
                File file = new File(path);
                if (file.exists()) {
                    if (ExtensionFunsKt.isVideo(file)) {
                        if (i12 != 0 && i11 != 2) {
                            z10 = false;
                        }
                        i11 = 2;
                    } else {
                        if (ExtensionFunsKt.isAudio(file)) {
                            i10 = 3;
                            if (i12 != 0 && i11 != 3) {
                                z10 = false;
                            }
                        } else {
                            i10 = 5;
                            if (i12 != 0 && i11 != 5) {
                                z10 = false;
                            }
                        }
                        i11 = i10;
                    }
                }
            }
            i12 = i13;
        }
        return BundleKt.bundleOf(z.a("type", Integer.valueOf(i11)), z.a("sameType", Boolean.valueOf(z10)));
    }
}
