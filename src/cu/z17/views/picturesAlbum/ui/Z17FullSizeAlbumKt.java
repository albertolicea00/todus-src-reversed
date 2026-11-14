package cu.z17.views.picturesAlbum.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import cu.z17.views.picturesAlbum.data.AlbumConfiguration;
import cu.z17.views.picturesAlbum.data.AlbumImage;
import cu.z17.views.picturesAlbum.data.AlbumOption;
import cu.z17.views.picturesAlbum.data.ImageRepository;
import cu.z17.views.picturesAlbum.theme.AlbumDimens;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import lb.o;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aa\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013²\u0006\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/picturesAlbum/data/AlbumConfiguration;", "albumConfiguration", "Lkotlin/Function1;", "", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "Lua/k0;", "onPhotoSelected", "Lcu/z17/views/picturesAlbum/data/AlbumOption;", "optionsList", "Landroidx/compose/ui/unit/Dp;", "size", "Lcu/z17/views/picturesAlbum/ui/AlbumViewModel;", "albumViewModel", "Z17FullSizeAlbum-WH-ejsw", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/picturesAlbum/data/AlbumConfiguration;Lkotlin/jvm/functions/Function1;Ljava/util/List;FLcu/z17/views/picturesAlbum/ui/AlbumViewModel;Landroidx/compose/runtime/Composer;II)V", "Z17FullSizeAlbum", "selectedList", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17FullSizeAlbumKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0134  */
    /* JADX WARN: Code duplicated, block: B:102:0x0138  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:105:0x0168  */
    /* JADX WARN: Code duplicated, block: B:107:0x0170  */
    /* JADX WARN: Code duplicated, block: B:110:0x017f  */
    /* JADX WARN: Code duplicated, block: B:113:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:114:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:119:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:125:0x020c  */
    /* JADX WARN: Code duplicated, block: B:128:0x021b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0223  */
    /* JADX WARN: Code duplicated, block: B:135:0x0259  */
    /* JADX WARN: Code duplicated, block: B:137:0x0263  */
    /* JADX WARN: Code duplicated, block: B:140:0x0271  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:98:0x0117  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnusedMaterial3ScaffoldPaddingParameter"})
    /* JADX INFO: renamed from: Z17FullSizeAlbum-WH-ejsw, reason: not valid java name */
    public static final void m10294Z17FullSizeAlbumWHejsw(Modifier modifier, AlbumConfiguration albumConfiguration, final Function1 onPhotoSelected, List<AlbumOption> list, float f10, AlbumViewModel albumViewModel, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        AlbumConfiguration albumConfiguration2;
        List<AlbumOption> list2;
        int i13;
        float f11;
        int i14;
        AlbumViewModel albumViewModel2;
        boolean z10;
        final Modifier modifier3;
        final AlbumConfiguration albumConfiguration3;
        final List<AlbumOption> list3;
        final float f12;
        final AlbumViewModel albumViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        AlbumConfiguration albumConfiguration4;
        List<AlbumOption> listN;
        float fM10290getTenD9Ej5fM;
        final AlbumConfiguration albumConfiguration5;
        int i15;
        final float f13;
        AlbumViewModelFactory albumViewModelFactory;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        final AlbumViewModel albumViewModel4;
        final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems;
        final State stateCollectAsState;
        Composer composer2;
        boolean z11;
        boolean z12;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composer3;
        final List<AlbumOption> list4;
        y.i(onPhotoSelected, "onPhotoSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-632149588);
        int i16 = i11 & 1;
        if (i16 != 0) {
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
            if ((i11 & 2) == 0) {
                albumConfiguration2 = albumConfiguration;
                int i17 = composerStartRestartGroup.changed(albumConfiguration2) ? 32 : 16;
                i12 |= i17;
            } else {
                albumConfiguration2 = albumConfiguration;
            }
            i12 |= i17;
        } else {
            albumConfiguration2 = albumConfiguration;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onPhotoSelected) ? 256 : 128;
        }
        int i18 = i11 & 8;
        if (i18 == 0) {
            if ((i10 & 3072) == 0) {
                list2 = list;
                i12 |= composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
            }
            i13 = i11 & 16;
            if (i13 != 0) {
                if ((i10 & 24576) == 0) {
                    f11 = f10;
                    if (composerStartRestartGroup.changed(f11)) {
                        i14 = 16384;
                    } else {
                        i14 = 8192;
                    }
                    i12 |= i14;
                }
                if ((196608 & i10) == 0) {
                    if ((i11 & 32) == 0) {
                        albumViewModel2 = albumViewModel;
                        int i19 = composerStartRestartGroup.changedInstance(albumViewModel2) ? 131072 : 65536;
                        i12 |= i19;
                    } else {
                        albumViewModel2 = albumViewModel;
                    }
                    i12 |= i19;
                } else {
                    albumViewModel2 = albumViewModel;
                }
                if ((i12 & 74899) != 74898) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i11 & 2) != 0) {
                            albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                            i12 &= -113;
                        } else {
                            albumConfiguration4 = albumConfiguration2;
                        }
                        if (i18 != 0) {
                            listN = w.n();
                        } else {
                            listN = list2;
                        }
                        if (i13 != 0) {
                            fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                        } else {
                            fM10290getTenD9Ej5fM = f11;
                        }
                        if ((i11 & 32) != 0) {
                            albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                            if (current == null) {
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                            if (current instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            ViewModel viewModel = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            int i20 = i12 & (-458753);
                            albumConfiguration5 = albumConfiguration4;
                            i15 = i20;
                            f13 = fM10290getTenD9Ej5fM;
                            albumViewModel4 = (AlbumViewModel) viewModel;
                        } else {
                            int i21 = i12;
                            albumConfiguration5 = albumConfiguration4;
                            i15 = i21;
                            f13 = fM10290getTenD9Ej5fM;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-632149588, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum (Z17FullSizeAlbum.kt:45)");
                        }
                        LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel4.getImages(), null, composerStartRestartGroup, 0, 1);
                        stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel4.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                        composer2 = composerStartRestartGroup;
                        z11 = false;
                        Modifier modifier5 = modifier4;
                        Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifier5, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                        GridCells.Fixed fixed = new GridCells.Fixed(3);
                        boolean zChangedInstance2 = composer2.changedInstance(listN);
                        if ((57344 & i15) == 16384) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean zChangedInstance3 = zChangedInstance2 | z12 | composer2.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composer2.changed(albumConfiguration5)) || (i15 & 48) == 32) | composer2.changed(stateCollectAsState);
                        if ((i15 & 896) == 256) {
                            z11 = true;
                        }
                        zChangedInstance = zChangedInstance3 | z11 | composer2.changedInstance(albumViewModel4);
                        objRememberedValue = composer2.rememberedValue();
                        if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            composer3 = composer2;
                            list4 = listN;
                            Function1 function1 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                                }
                            };
                            composer3.updateRememberedValue(function1);
                            objRememberedValue = function1;
                        } else {
                            composer3 = composer2;
                            list4 = listN;
                        }
                        Composer composer4 = composer3;
                        LazyGridDslKt.LazyVerticalGrid(fixed, modifierM1205backgroundbw27NRU$default, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer4, 0, 0, 1016);
                        composerStartRestartGroup = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f12 = f13;
                        albumConfiguration3 = albumConfiguration5;
                        albumViewModel3 = albumViewModel4;
                        list3 = list4;
                        modifier3 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 2) != 0) {
                            i12 &= -113;
                        }
                        if ((i11 & 32) != 0) {
                            i12 &= -458753;
                        }
                        modifier4 = modifier2;
                        i15 = i12;
                        albumConfiguration5 = albumConfiguration2;
                        listN = list2;
                        f13 = f11;
                    }
                    albumViewModel4 = albumViewModel2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632149588, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum (Z17FullSizeAlbum.kt:45)");
                    }
                    LazyGridState lazyGridStateRememberLazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel4.getImages(), null, composerStartRestartGroup, 0, 1);
                    stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel4.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                    composer2 = composerStartRestartGroup;
                    z11 = false;
                    Modifier modifier6 = modifier4;
                    Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifier6, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                    GridCells.Fixed fixed2 = new GridCells.Fixed(3);
                    boolean zChangedInstance4 = composer2.changedInstance(listN);
                    if ((57344 & i15) == 16384) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance5 = zChangedInstance4 | z12 | composer2.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composer2.changed(albumConfiguration5)) || (i15 & 48) == 32) | composer2.changed(stateCollectAsState);
                    if ((i15 & 896) == 256) {
                        z11 = true;
                    }
                    zChangedInstance = zChangedInstance5 | z11 | composer2.changedInstance(albumViewModel4);
                    objRememberedValue = composer2.rememberedValue();
                    if (zChangedInstance) {
                        composer3 = composer2;
                        list4 = listN;
                        Function1 function2 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                            }
                        };
                        composer3.updateRememberedValue(function2);
                        objRememberedValue = function2;
                    } else {
                        composer3 = composer2;
                        list4 = listN;
                        Function1 function3 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                            }
                        };
                        composer3.updateRememberedValue(function3);
                        objRememberedValue = function3;
                    }
                    Composer composer5 = composer3;
                    LazyGridDslKt.LazyVerticalGrid(fixed2, modifierM1205backgroundbw27NRU$default2, lazyGridStateRememberLazyGridState2, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer5, 0, 0, 1016);
                    composerStartRestartGroup = composer5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f12 = f13;
                    albumConfiguration3 = albumConfiguration5;
                    albumViewModel3 = albumViewModel4;
                    list3 = list4;
                    modifier3 = modifier6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    albumConfiguration3 = albumConfiguration2;
                    list3 = list2;
                    f12 = f11;
                    albumViewModel3 = albumViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, f12, albumViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 24576;
            f11 = f10;
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    albumViewModel2 = albumViewModel;
                    if (composerStartRestartGroup.changedInstance(albumViewModel2)) {
                    }
                    i12 |= i19;
                } else {
                    albumViewModel2 = albumViewModel;
                }
                i12 |= i19;
            } else {
                albumViewModel2 = albumViewModel;
            }
            if ((i12 & 74899) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        albumConfiguration4 = albumConfiguration2;
                    }
                    if (i18 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f11;
                    }
                    if ((i11 & 32) != 0) {
                        albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        int i22 = i12 & (-458753);
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i22;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = (AlbumViewModel) viewModel2;
                    } else {
                        int i23 = i12;
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i23;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = albumViewModel2;
                    }
                } else {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        albumConfiguration4 = albumConfiguration2;
                    }
                    if (i18 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f11;
                    }
                    if ((i11 & 32) != 0) {
                        albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        int i24 = i12 & (-458753);
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i24;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = (AlbumViewModel) viewModel3;
                    } else {
                        int i25 = i12;
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i25;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = albumViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632149588, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum (Z17FullSizeAlbum.kt:45)");
                }
                LazyGridState lazyGridStateRememberLazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel4.getImages(), null, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel4.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                composer2 = composerStartRestartGroup;
                z11 = false;
                Modifier modifier7 = modifier4;
                Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(modifier7, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed3 = new GridCells.Fixed(3);
                boolean zChangedInstance6 = composer2.changedInstance(listN);
                if ((57344 & i15) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance7 = zChangedInstance6 | z12 | composer2.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composer2.changed(albumConfiguration5)) || (i15 & 48) == 32) | composer2.changed(stateCollectAsState);
                if ((i15 & 896) == 256) {
                    z11 = true;
                }
                zChangedInstance = zChangedInstance7 | z11 | composer2.changedInstance(albumViewModel4);
                objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance) {
                    composer3 = composer2;
                    list4 = listN;
                    Function1 function4 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(function4);
                    objRememberedValue = function4;
                } else {
                    composer3 = composer2;
                    list4 = listN;
                    Function1 function5 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(function5);
                    objRememberedValue = function5;
                }
                Composer composer6 = composer3;
                LazyGridDslKt.LazyVerticalGrid(fixed3, modifierM1205backgroundbw27NRU$default3, lazyGridStateRememberLazyGridState3, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer6, 0, 0, 1016);
                composerStartRestartGroup = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                albumConfiguration3 = albumConfiguration5;
                albumViewModel3 = albumViewModel4;
                list3 = list4;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                albumConfiguration3 = albumConfiguration2;
                list3 = list2;
                f12 = f11;
                albumViewModel3 = albumViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, f12, albumViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        list2 = list;
        i13 = i11 & 16;
        if (i13 != 0) {
            if ((i10 & 24576) == 0) {
                f11 = f10;
                if (composerStartRestartGroup.changed(f11)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i12 |= i14;
            }
            if ((196608 & i10) == 0) {
                if ((i11 & 32) == 0) {
                    albumViewModel2 = albumViewModel;
                    if (composerStartRestartGroup.changedInstance(albumViewModel2)) {
                    }
                    i12 |= i19;
                } else {
                    albumViewModel2 = albumViewModel;
                }
                i12 |= i19;
            } else {
                albumViewModel2 = albumViewModel;
            }
            if ((i12 & 74899) != 74898) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i10 & 1) != 0) {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        albumConfiguration4 = albumConfiguration2;
                    }
                    if (i18 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f11;
                    }
                    if ((i11 & 32) != 0) {
                        albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel4 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        int i26 = i12 & (-458753);
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i26;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = (AlbumViewModel) viewModel4;
                    } else {
                        int i27 = i12;
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i27;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = albumViewModel2;
                    }
                } else {
                    if (i16 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        albumConfiguration4 = albumConfiguration2;
                    }
                    if (i18 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f11;
                    }
                    if ((i11 & 32) != 0) {
                        albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel5 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        int i28 = i12 & (-458753);
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i28;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = (AlbumViewModel) viewModel5;
                    } else {
                        int i29 = i12;
                        albumConfiguration5 = albumConfiguration4;
                        i15 = i29;
                        f13 = fM10290getTenD9Ej5fM;
                        albumViewModel4 = albumViewModel2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632149588, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum (Z17FullSizeAlbum.kt:45)");
                }
                LazyGridState lazyGridStateRememberLazyGridState4 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel4.getImages(), null, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel4.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                composer2 = composerStartRestartGroup;
                z11 = false;
                Modifier modifier8 = modifier4;
                Modifier modifierM1205backgroundbw27NRU$default4 = BackgroundKt.m1205backgroundbw27NRU$default(modifier8, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed4 = new GridCells.Fixed(3);
                boolean zChangedInstance8 = composer2.changedInstance(listN);
                if ((57344 & i15) == 16384) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance9 = zChangedInstance8 | z12 | composer2.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composer2.changed(albumConfiguration5)) || (i15 & 48) == 32) | composer2.changed(stateCollectAsState);
                if ((i15 & 896) == 256) {
                    z11 = true;
                }
                zChangedInstance = zChangedInstance9 | z11 | composer2.changedInstance(albumViewModel4);
                objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance) {
                    composer3 = composer2;
                    list4 = listN;
                    Function1 function6 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(function6);
                    objRememberedValue = function6;
                } else {
                    composer3 = composer2;
                    list4 = listN;
                    Function1 function7 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(function7);
                    objRememberedValue = function7;
                }
                Composer composer7 = composer3;
                LazyGridDslKt.LazyVerticalGrid(fixed4, modifierM1205backgroundbw27NRU$default4, lazyGridStateRememberLazyGridState4, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer7, 0, 0, 1016);
                composerStartRestartGroup = composer7;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                albumConfiguration3 = albumConfiguration5;
                albumViewModel3 = albumViewModel4;
                list3 = list4;
                modifier3 = modifier8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                albumConfiguration3 = albumConfiguration2;
                list3 = list2;
                f12 = f11;
                albumViewModel3 = albumViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, f12, albumViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 24576;
        f11 = f10;
        if ((196608 & i10) == 0) {
            if ((i11 & 32) == 0) {
                albumViewModel2 = albumViewModel;
                if (composerStartRestartGroup.changedInstance(albumViewModel2)) {
                }
                i12 |= i19;
            } else {
                albumViewModel2 = albumViewModel;
            }
            i12 |= i19;
        } else {
            albumViewModel2 = albumViewModel;
        }
        if ((i12 & 74899) != 74898) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) != 0) {
                if (i16 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                    i12 &= -113;
                } else {
                    albumConfiguration4 = albumConfiguration2;
                }
                if (i18 != 0) {
                    listN = w.n();
                } else {
                    listN = list2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f11;
                }
                if ((i11 & 32) != 0) {
                    albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel6 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    int i210 = i12 & (-458753);
                    albumConfiguration5 = albumConfiguration4;
                    i15 = i210;
                    f13 = fM10290getTenD9Ej5fM;
                    albumViewModel4 = (AlbumViewModel) viewModel6;
                } else {
                    int i211 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    i15 = i211;
                    f13 = fM10290getTenD9Ej5fM;
                    albumViewModel4 = albumViewModel2;
                }
            } else {
                if (i16 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    albumConfiguration4 = new AlbumConfiguration(false, 1, null);
                    i12 &= -113;
                } else {
                    albumConfiguration4 = albumConfiguration2;
                }
                if (i18 != 0) {
                    listN = w.n();
                } else {
                    listN = list2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f11;
                }
                if ((i11 & 32) != 0) {
                    albumViewModelFactory = new AlbumViewModelFactory(new ImageRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel7 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, ExifInterface.GPS_MEASUREMENT_2D, albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    int i212 = i12 & (-458753);
                    albumConfiguration5 = albumConfiguration4;
                    i15 = i212;
                    f13 = fM10290getTenD9Ej5fM;
                    albumViewModel4 = (AlbumViewModel) viewModel7;
                } else {
                    int i213 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    i15 = i213;
                    f13 = fM10290getTenD9Ej5fM;
                    albumViewModel4 = albumViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-632149588, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum (Z17FullSizeAlbum.kt:45)");
            }
            LazyGridState lazyGridStateRememberLazyGridState5 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel4.getImages(), null, composerStartRestartGroup, 0, 1);
            stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel4.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
            composer2 = composerStartRestartGroup;
            z11 = false;
            Modifier modifier9 = modifier4;
            Modifier modifierM1205backgroundbw27NRU$default5 = BackgroundKt.m1205backgroundbw27NRU$default(modifier9, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
            GridCells.Fixed fixed5 = new GridCells.Fixed(3);
            boolean zChangedInstance10 = composer2.changedInstance(listN);
            if ((57344 & i15) == 16384) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean zChangedInstance11 = zChangedInstance10 | z12 | composer2.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composer2.changed(albumConfiguration5)) || (i15 & 48) == 32) | composer2.changed(stateCollectAsState);
            if ((i15 & 896) == 256) {
                z11 = true;
            }
            zChangedInstance = zChangedInstance11 | z11 | composer2.changedInstance(albumViewModel4);
            objRememberedValue = composer2.rememberedValue();
            if (zChangedInstance) {
                composer3 = composer2;
                list4 = listN;
                Function1 function8 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                    }
                };
                composer3.updateRememberedValue(function8);
                objRememberedValue = function8;
            } else {
                composer3 = composer2;
                list4 = listN;
                Function1 function9 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel4, (LazyGridScope) obj);
                    }
                };
                composer3.updateRememberedValue(function9);
                objRememberedValue = function9;
            }
            Composer composer8 = composer3;
            LazyGridDslKt.LazyVerticalGrid(fixed5, modifierM1205backgroundbw27NRU$default5, lazyGridStateRememberLazyGridState5, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer8, 0, 0, 1016);
            composerStartRestartGroup = composer8;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f12 = f13;
            albumConfiguration3 = albumConfiguration5;
            albumViewModel3 = albumViewModel4;
            list3 = list4;
            modifier3 = modifier9;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            albumConfiguration3 = albumConfiguration2;
            list3 = list2;
            f12 = f11;
            albumViewModel3 = albumViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, f12, albumViewModel3, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<AlbumImage> Z17FullSizeAlbum_WH_ejsw$lambda$0(State<? extends List<AlbumImage>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9(List list, final LazyPagingItems lazyPagingItems, final float f10, final AlbumConfiguration albumConfiguration, final Function1 function1, final State state, final AlbumViewModel albumViewModel, LazyGridScope LazyVerticalGrid) {
        y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyVerticalGrid.items(list.size(), null, null, new Z17FullSizeAlbumKt$Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$$inlined$itemsIndexed$default$3(list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Z17FullSizeAlbumKt$Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$$inlined$itemsIndexed$default$4(list, f10)));
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), null, null, null, ComposableLambdaKt.composableLambdaInstance(520420913, true, new o() { // from class: cu.z17.views.picturesAlbum.ui.e
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8(lazyPagingItems, albumConfiguration, function1, state, albumViewModel, f10, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 14, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8(LazyPagingItems lazyPagingItems, final AlbumConfiguration albumConfiguration, final Function1 function1, final State state, final AlbumViewModel albumViewModel, float f10, LazyGridItemScope items, int i10, Composer composer, int i11) {
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(520420913, i11, -1, "cu.z17.views.picturesAlbum.ui.Z17FullSizeAlbum.<anonymous>.<anonymous>.<anonymous> (Z17FullSizeAlbum.kt:77)");
            }
            final AlbumImage albumImage = (AlbumImage) lazyPagingItems.get(i10);
            if (albumImage == null) {
                composer.startReplaceGroup(-972442465);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-972442464);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, AlbumDimens.INSTANCE.m10284getHalfQuarterD9Ej5fM());
                boolean multipleImagesAllowed = albumConfiguration.getMultipleImagesAllowed();
                boolean zContains = Z17FullSizeAlbum_WH_ejsw$lambda$0(state).contains(albumImage);
                boolean zChanged = composer.changed(albumConfiguration) | composer.changed(function1) | composer.changed(state) | composer.changedInstance(albumImage) | composer.changedInstance(albumViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(albumConfiguration, function1, albumImage, albumViewModel, state, (AlbumImage) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                CommonKt.m10293AlbumImageItemHYR8e34(modifierM1725padding3ABfNKs, albumImage, multipleImagesAllowed, zContains, (Function1) objRememberedValue, f10, composer, 6, 0);
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
    public static final k0 Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(AlbumConfiguration albumConfiguration, Function1 function1, AlbumImage albumImage, AlbumViewModel albumViewModel, State state, final AlbumImage image) {
        y.i(image, "image");
        if (!albumConfiguration.getMultipleImagesAllowed()) {
            function1.invoke(w.g(image));
        } else if (Z17FullSizeAlbum_WH_ejsw$lambda$0(state).contains(albumImage)) {
            function1.invoke(albumViewModel.getSelectedList().removeAll(new Function1() { // from class: cu.z17.views.picturesAlbum.ui.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Z17FullSizeAlbumKt.Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(image, (AlbumImage) obj));
                }
            }));
        } else {
            function1.invoke(albumViewModel.getSelectedList().add(albumImage));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17FullSizeAlbum_WH_ejsw$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(AlbumImage albumImage, AlbumImage it) {
        y.i(it, "it");
        return y.d(it.getId$views_release(), albumImage.getId$views_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17FullSizeAlbum_WH_ejsw$lambda$11(Modifier modifier, AlbumConfiguration albumConfiguration, Function1 function1, List list, float f10, AlbumViewModel albumViewModel, int i10, int i11, Composer composer, int i12) {
        m10294Z17FullSizeAlbumWHejsw(modifier, albumConfiguration, function1, list, f10, albumViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
