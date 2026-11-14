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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import androidx.profileinstaller.ProfileVerifier;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aa\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013²\u0006\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/picturesAlbum/data/AlbumConfiguration;", "albumConfiguration", "Lkotlin/Function1;", "", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "Lua/k0;", "onPhotoSelected", "Lcu/z17/views/picturesAlbum/data/AlbumOption;", "optionsList", "Lcu/z17/views/picturesAlbum/ui/AlbumViewModel;", "albumViewModel", "Landroidx/compose/ui/unit/Dp;", "size", "Z17RowAlbum-HYR8e34", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/picturesAlbum/data/AlbumConfiguration;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lcu/z17/views/picturesAlbum/ui/AlbumViewModel;FLandroidx/compose/runtime/Composer;II)V", "Z17RowAlbum", "selectedList", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17RowAlbumKt {
    /* JADX WARN: Code duplicated, block: B:101:0x015b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0163  */
    /* JADX WARN: Code duplicated, block: B:105:0x0167  */
    /* JADX WARN: Code duplicated, block: B:107:0x0175  */
    /* JADX WARN: Code duplicated, block: B:110:0x0184  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:119:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:125:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:128:0x020b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0216  */
    /* JADX WARN: Code duplicated, block: B:135:0x0249  */
    /* JADX WARN: Code duplicated, block: B:137:0x0253  */
    /* JADX WARN: Code duplicated, block: B:140:0x0262  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:96:0x012b  */
    /* JADX WARN: Code duplicated, block: B:98:0x012f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0137  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnusedMaterial3ScaffoldPaddingParameter"})
    /* JADX INFO: renamed from: Z17RowAlbum-HYR8e34, reason: not valid java name */
    public static final void m10297Z17RowAlbumHYR8e34(Modifier modifier, AlbumConfiguration albumConfiguration, final Function1 onPhotoSelected, List<AlbumOption> list, AlbumViewModel albumViewModel, float f10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        AlbumConfiguration albumConfiguration2;
        List<AlbumOption> list2;
        AlbumViewModel albumViewModel2;
        int i13;
        float f11;
        int i14;
        boolean z10;
        final float f12;
        final Modifier modifier3;
        final AlbumConfiguration albumConfiguration3;
        final List<AlbumOption> list3;
        final AlbumViewModel albumViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        AlbumConfiguration albumConfiguration4;
        final List<AlbumOption> listN;
        ab.i iVar;
        AlbumViewModel albumViewModel4;
        final float fM10290getTenD9Ej5fM;
        int i15;
        final AlbumConfiguration albumConfiguration5;
        AlbumViewModel albumViewModel5;
        AlbumViewModelFactory albumViewModelFactory;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems;
        final State stateCollectAsState;
        boolean z11;
        boolean zChangedInstance;
        Object objRememberedValue;
        final AlbumViewModel albumViewModel6;
        y.i(onPhotoSelected, "onPhotoSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(2031029786);
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
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    albumViewModel2 = albumViewModel;
                    int i19 = composerStartRestartGroup.changedInstance(albumViewModel2) ? 16384 : 8192;
                    i12 |= i19;
                } else {
                    albumViewModel2 = albumViewModel;
                }
                i12 |= i19;
            } else {
                albumViewModel2 = albumViewModel;
            }
            i13 = i11 & 32;
            if (i13 != 0) {
                if ((196608 & i10) == 0) {
                    f11 = f10;
                    if (composerStartRestartGroup.changed(f11)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i12 |= i14;
                }
                if ((74899 & i12) != 74898) {
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
                        if ((i11 & 16) != 0) {
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
                            iVar = null;
                            ViewModel viewModel = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            albumViewModel4 = (AlbumViewModel) viewModel;
                            i12 &= -57345;
                        } else {
                            iVar = null;
                            albumViewModel4 = albumViewModel2;
                        }
                        if (i13 != 0) {
                            fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                        } else {
                            fM10290getTenD9Ej5fM = f10;
                        }
                        i15 = i12;
                        albumConfiguration5 = albumConfiguration4;
                        albumViewModel5 = albumViewModel4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 2) != 0) {
                            i12 &= -113;
                        }
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                        }
                        AlbumConfiguration albumConfiguration6 = albumConfiguration2;
                        i15 = i12;
                        albumConfiguration5 = albumConfiguration6;
                        modifier4 = modifier2;
                        listN = list2;
                        albumViewModel5 = albumViewModel2;
                        fM10290getTenD9Ej5fM = f11;
                        iVar = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031029786, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17RowAlbum (Z17RowAlbum.kt:45)");
                    }
                    LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel5.getImages(), iVar, composerStartRestartGroup, 0, 1);
                    stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    GridCells.Fixed fixed = new GridCells.Fixed(1);
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(listN);
                    if ((458752 & i15) == 131072) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zChangedInstance = z11 | zChangedInstance2 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(albumConfiguration5)) || (i15 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState) | ((i15 & 896) == 256) | composerStartRestartGroup.changedInstance(albumViewModel5);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        albumViewModel6 = albumViewModel5;
                        Function1 function1 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1);
                        objRememberedValue = function1;
                    } else {
                        albumViewModel6 = albumViewModel5;
                    }
                    Composer composer2 = composerStartRestartGroup;
                    LazyGridDslKt.LazyHorizontalGrid(fixed, modifierM1205backgroundbw27NRU$default, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 0, 1016);
                    composerStartRestartGroup = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f12 = fM10290getTenD9Ej5fM;
                    albumConfiguration3 = albumConfiguration5;
                    albumViewModel3 = albumViewModel6;
                    list3 = listN;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f12 = f10;
                    modifier3 = modifier2;
                    albumConfiguration3 = albumConfiguration2;
                    list3 = list2;
                    albumViewModel3 = albumViewModel2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, albumViewModel3, f12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f11 = f10;
            if ((74899 & i12) != 74898) {
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
                    if ((i11 & 16) != 0) {
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
                        iVar = null;
                        ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        albumViewModel4 = (AlbumViewModel) viewModel2;
                        i12 &= -57345;
                    } else {
                        iVar = null;
                        albumViewModel4 = albumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    i15 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    albumViewModel5 = albumViewModel4;
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
                    if ((i11 & 16) != 0) {
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
                        iVar = null;
                        ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        albumViewModel4 = (AlbumViewModel) viewModel3;
                        i12 &= -57345;
                    } else {
                        iVar = null;
                        albumViewModel4 = albumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    i15 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    albumViewModel5 = albumViewModel4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031029786, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17RowAlbum (Z17RowAlbum.kt:45)");
                }
                LazyGridState lazyGridStateRememberLazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel5.getImages(), iVar, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed2 = new GridCells.Fixed(1);
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(listN);
                if ((458752 & i15) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChangedInstance = z11 | zChangedInstance3 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(albumConfiguration5)) || (i15 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState) | ((i15 & 896) == 256) | composerStartRestartGroup.changedInstance(albumViewModel5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    albumViewModel6 = albumViewModel5;
                    Function1 function2 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function2);
                    objRememberedValue = function2;
                } else {
                    albumViewModel6 = albumViewModel5;
                    Function1 function3 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function3);
                    objRememberedValue = function3;
                }
                Composer composer3 = composerStartRestartGroup;
                LazyGridDslKt.LazyHorizontalGrid(fixed2, modifierM1205backgroundbw27NRU$default2, lazyGridStateRememberLazyGridState2, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer3, 0, 0, 1016);
                composerStartRestartGroup = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = fM10290getTenD9Ej5fM;
                albumConfiguration3 = albumConfiguration5;
                albumViewModel3 = albumViewModel6;
                list3 = listN;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f10;
                modifier3 = modifier2;
                albumConfiguration3 = albumConfiguration2;
                list3 = list2;
                albumViewModel3 = albumViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, albumViewModel3, f12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        list2 = list;
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
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
        i13 = i11 & 32;
        if (i13 != 0) {
            if ((196608 & i10) == 0) {
                f11 = f10;
                if (composerStartRestartGroup.changed(f11)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i12 |= i14;
            }
            if ((74899 & i12) != 74898) {
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
                    if ((i11 & 16) != 0) {
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
                        iVar = null;
                        ViewModel viewModel4 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        albumViewModel4 = (AlbumViewModel) viewModel4;
                        i12 &= -57345;
                    } else {
                        iVar = null;
                        albumViewModel4 = albumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    i15 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    albumViewModel5 = albumViewModel4;
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
                    if ((i11 & 16) != 0) {
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
                        iVar = null;
                        ViewModel viewModel5 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        albumViewModel4 = (AlbumViewModel) viewModel5;
                        i12 &= -57345;
                    } else {
                        iVar = null;
                        albumViewModel4 = albumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    i15 = i12;
                    albumConfiguration5 = albumConfiguration4;
                    albumViewModel5 = albumViewModel4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031029786, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17RowAlbum (Z17RowAlbum.kt:45)");
                }
                LazyGridState lazyGridStateRememberLazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel5.getImages(), iVar, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed3 = new GridCells.Fixed(1);
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(listN);
                if ((458752 & i15) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zChangedInstance = z11 | zChangedInstance4 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(albumConfiguration5)) || (i15 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState) | ((i15 & 896) == 256) | composerStartRestartGroup.changedInstance(albumViewModel5);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    albumViewModel6 = albumViewModel5;
                    Function1 function4 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function4);
                    objRememberedValue = function4;
                } else {
                    albumViewModel6 = albumViewModel5;
                    Function1 function5 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function5);
                    objRememberedValue = function5;
                }
                Composer composer4 = composerStartRestartGroup;
                LazyGridDslKt.LazyHorizontalGrid(fixed3, modifierM1205backgroundbw27NRU$default3, lazyGridStateRememberLazyGridState3, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer4, 0, 0, 1016);
                composerStartRestartGroup = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = fM10290getTenD9Ej5fM;
                albumConfiguration3 = albumConfiguration5;
                albumViewModel3 = albumViewModel6;
                list3 = listN;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f10;
                modifier3 = modifier2;
                albumConfiguration3 = albumConfiguration2;
                list3 = list2;
                albumViewModel3 = albumViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, albumViewModel3, f12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f11 = f10;
        if ((74899 & i12) != 74898) {
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
                if ((i11 & 16) != 0) {
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
                    iVar = null;
                    ViewModel viewModel6 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    albumViewModel4 = (AlbumViewModel) viewModel6;
                    i12 &= -57345;
                } else {
                    iVar = null;
                    albumViewModel4 = albumViewModel2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f10;
                }
                i15 = i12;
                albumConfiguration5 = albumConfiguration4;
                albumViewModel5 = albumViewModel4;
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
                if ((i11 & 16) != 0) {
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
                    iVar = null;
                    ViewModel viewModel7 = ViewModelKt.viewModel(z0.b(AlbumViewModel.class), current, "1", albumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    albumViewModel4 = (AlbumViewModel) viewModel7;
                    i12 &= -57345;
                } else {
                    iVar = null;
                    albumViewModel4 = albumViewModel2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f10;
                }
                i15 = i12;
                albumConfiguration5 = albumConfiguration4;
                albumViewModel5 = albumViewModel4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031029786, i15, -1, "cu.z17.views.picturesAlbum.ui.Z17RowAlbum (Z17RowAlbum.kt:45)");
            }
            LazyGridState lazyGridStateRememberLazyGridState4 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(albumViewModel5.getImages(), iVar, composerStartRestartGroup, 0, 1);
            stateCollectAsState = SnapshotStateKt.collectAsState(albumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
            Modifier modifierM1205backgroundbw27NRU$default4 = BackgroundKt.m1205backgroundbw27NRU$default(modifier4, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            GridCells.Fixed fixed4 = new GridCells.Fixed(1);
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(listN);
            if ((458752 & i15) == 131072) {
                z11 = true;
            } else {
                z11 = false;
            }
            zChangedInstance = z11 | zChangedInstance5 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i15 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(albumConfiguration5)) || (i15 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState) | ((i15 & 896) == 256) | composerStartRestartGroup.changedInstance(albumViewModel5);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                albumViewModel6 = albumViewModel5;
                Function1 function6 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function6);
                objRememberedValue = function6;
            } else {
                albumViewModel6 = albumViewModel5;
                Function1 function7 = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9(listN, lazyPagingItemsCollectAsLazyPagingItems, fM10290getTenD9Ej5fM, albumConfiguration5, onPhotoSelected, stateCollectAsState, albumViewModel6, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function7);
                objRememberedValue = function7;
            }
            Composer composer5 = composerStartRestartGroup;
            LazyGridDslKt.LazyHorizontalGrid(fixed4, modifierM1205backgroundbw27NRU$default4, lazyGridStateRememberLazyGridState4, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer5, 0, 0, 1016);
            composerStartRestartGroup = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f12 = fM10290getTenD9Ej5fM;
            albumConfiguration3 = albumConfiguration5;
            albumViewModel3 = albumViewModel6;
            list3 = listN;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f12 = f10;
            modifier3 = modifier2;
            albumConfiguration3 = albumConfiguration2;
            list3 = list2;
            albumViewModel3 = albumViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.picturesAlbum.ui.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$11(modifier3, albumConfiguration3, onPhotoSelected, list3, albumViewModel3, f12, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<AlbumImage> Z17RowAlbum_HYR8e34$lambda$0(State<? extends List<AlbumImage>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17RowAlbum_HYR8e34$lambda$10$lambda$9(List list, final LazyPagingItems lazyPagingItems, final float f10, final AlbumConfiguration albumConfiguration, final Function1 function1, final State state, final AlbumViewModel albumViewModel, LazyGridScope LazyHorizontalGrid) {
        y.i(LazyHorizontalGrid, "$this$LazyHorizontalGrid");
        LazyHorizontalGrid.items(list.size(), null, null, new Z17RowAlbumKt$Z17RowAlbum_HYR8e34$lambda$10$lambda$9$$inlined$itemsIndexed$default$3(list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Z17RowAlbumKt$Z17RowAlbum_HYR8e34$lambda$10$lambda$9$$inlined$itemsIndexed$default$4(list, f10)));
        LazyGridScope.CC.b(LazyHorizontalGrid, lazyPagingItems.getItemCount(), null, null, null, ComposableLambdaKt.composableLambdaInstance(-2040142195, true, new o() { // from class: cu.z17.views.picturesAlbum.ui.k
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8(lazyPagingItems, albumConfiguration, function1, state, albumViewModel, f10, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 14, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8(LazyPagingItems lazyPagingItems, final AlbumConfiguration albumConfiguration, final Function1 function1, final State state, final AlbumViewModel albumViewModel, float f10, LazyGridItemScope items, int i10, Composer composer, int i11) {
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i11 |= composer.changed(i10) ? 32 : 16;
        }
        if (composer.shouldExecute((i11 & 145) != 144, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040142195, i11, -1, "cu.z17.views.picturesAlbum.ui.Z17RowAlbum.<anonymous>.<anonymous>.<anonymous> (Z17RowAlbum.kt:78)");
            }
            final AlbumImage albumImage = (AlbumImage) lazyPagingItems.get(i10);
            if (albumImage == null) {
                composer.startReplaceGroup(206151363);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(206151364);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, AlbumDimens.INSTANCE.m10284getHalfQuarterD9Ej5fM());
                boolean multipleImagesAllowed = albumConfiguration.getMultipleImagesAllowed();
                boolean zContains = Z17RowAlbum_HYR8e34$lambda$0(state).contains(albumImage);
                boolean zChanged = composer.changed(albumConfiguration) | composer.changed(function1) | composer.changed(state) | composer.changedInstance(albumImage) | composer.changedInstance(albumViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: cu.z17.views.picturesAlbum.ui.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(albumConfiguration, function1, albumImage, albumViewModel, state, (AlbumImage) obj2);
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
    public static final k0 Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5(AlbumConfiguration albumConfiguration, Function1 function1, AlbumImage albumImage, AlbumViewModel albumViewModel, State state, final AlbumImage image) {
        y.i(image, "image");
        if (!albumConfiguration.getMultipleImagesAllowed()) {
            function1.invoke(w.g(image));
        } else if (Z17RowAlbum_HYR8e34$lambda$0(state).contains(albumImage)) {
            function1.invoke(albumViewModel.getSelectedList().removeAll(new Function1() { // from class: cu.z17.views.picturesAlbum.ui.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Z17RowAlbumKt.Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(image, (AlbumImage) obj));
                }
            }));
        } else {
            function1.invoke(albumViewModel.getSelectedList().add(albumImage));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17RowAlbum_HYR8e34$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(AlbumImage albumImage, AlbumImage it) {
        y.i(it, "it");
        return y.d(it.getId$views_release(), albumImage.getId$views_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17RowAlbum_HYR8e34$lambda$11(Modifier modifier, AlbumConfiguration albumConfiguration, Function1 function1, List list, AlbumViewModel albumViewModel, float f10, int i10, int i11, Composer composer, int i12) {
        m10297Z17RowAlbumHYR8e34(modifier, albumConfiguration, function1, list, albumViewModel, f10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
