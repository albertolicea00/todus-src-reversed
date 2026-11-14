package cu.z17.views.videosAlbum.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.picturesAlbum.data.AlbumOption;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u000b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "", "it", "Lua/k0;", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$5", "<anonymous>"}, k = 3, mv = {2, 2, 0})
public final class Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$4 extends e0 implements lb.o {
    final /* synthetic */ List $items;
    final /* synthetic */ float $size$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$4(List list, float f10) {
        super(4);
        this.$items = list;
        this.$size$inlined = f10;
    }

    @Override // lb.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return k0.f43947a;
    }

    @Composable
    public final void invoke(LazyGridItemScope lazyGridItemScope, int i10, Composer composer, int i11) {
        int i12;
        if ((i11 & 6) == 0) {
            i12 = i11 | (composer.changed(lazyGridItemScope) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= composer.changed(i10) ? 32 : 16;
        }
        if (!composer.shouldExecute((i12 & 147) != 146, i12 & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1229287273, i12, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:579)");
        }
        final AlbumOption albumOption = (AlbumOption) this.$items.get(i10);
        composer.startReplaceGroup(-1550636324);
        Alignment center = Alignment.INSTANCE.getCenter();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(companion, this.$size$inlined);
        boolean zChangedInstance = composer.changedInstance(albumOption);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum$2$1$1$1$1
                @Override // lb.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m10326invoke();
                    return k0.f43947a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m10326invoke() {
                    albumOption.getFunction().invoke();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(modifierM1769size3ABfNKs, false, null, null, (lb.a) objRememberedValue, 7, null);
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        int i13 = MaterialTheme.$stable;
        Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierM1238clickableXHw0xAI$default, materialTheme.getColorScheme(composer, i13).getBackground(), null, 2, null);
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
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
        Z17PictureKt.m10278Z17BasePictureC8z9wKI(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m8823constructorimpl(this.$size$inlined / 3)), albumOption.getPreview(), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, materialTheme.getColorScheme(composer, i13).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 0, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
        composer.endNode();
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
