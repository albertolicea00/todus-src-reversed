package cu.z17.views.videosAlbum.ui;

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
import cu.z17.views.picturesAlbum.data.AlbumOption;
import cu.z17.views.picturesAlbum.theme.AlbumDimens;
import cu.z17.views.videosAlbum.data.VideoAlbum;
import cu.z17.views.videosAlbum.data.VideoAlbumConfiguration;
import cu.z17.views.videosAlbum.data.VideoRepository;
import cu.z17.views.videosAlbum.theme.VideoAlbumDimens;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aw\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015²\u0006\u0012\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/videosAlbum/data/VideoAlbumConfiguration;", "albumConfiguration", "Lkotlin/Function1;", "", "Lcu/z17/views/videosAlbum/data/VideoAlbum;", "Lua/k0;", "onVideoSelected", "Lcu/z17/views/picturesAlbum/data/AlbumOption;", "optionsList", "Lcu/z17/views/videosAlbum/ui/VideoAlbumViewModel;", "albumViewModel", "Landroidx/compose/ui/unit/Dp;", "size", "", "onRequestRealPath", "Z17FullSizeVideoAlbum-PfoAEA0", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/videosAlbum/data/VideoAlbumConfiguration;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lcu/z17/views/videosAlbum/ui/VideoAlbumViewModel;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Z17FullSizeVideoAlbum", "selectedList", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Z17FullSizeVideoAlbumKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:101:0x0126  */
    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0148  */
    /* JADX WARN: Code duplicated, block: B:108:0x014c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0154  */
    /* JADX WARN: Code duplicated, block: B:111:0x0178  */
    /* JADX WARN: Code duplicated, block: B:113:0x0180  */
    /* JADX WARN: Code duplicated, block: B:115:0x0184  */
    /* JADX WARN: Code duplicated, block: B:116:0x018b  */
    /* JADX WARN: Code duplicated, block: B:118:0x018f  */
    /* JADX WARN: Code duplicated, block: B:120:0x019b  */
    /* JADX WARN: Code duplicated, block: B:125:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:128:0x0211  */
    /* JADX WARN: Code duplicated, block: B:129:0x0213  */
    /* JADX WARN: Code duplicated, block: B:132:0x0222  */
    /* JADX WARN: Code duplicated, block: B:134:0x0228  */
    /* JADX WARN: Code duplicated, block: B:140:0x023b  */
    /* JADX WARN: Code duplicated, block: B:141:0x023d  */
    /* JADX WARN: Code duplicated, block: B:144:0x024b  */
    /* JADX WARN: Code duplicated, block: B:145:0x024d  */
    /* JADX WARN: Code duplicated, block: B:148:0x0256  */
    /* JADX WARN: Code duplicated, block: B:152:0x0263  */
    /* JADX WARN: Code duplicated, block: B:155:0x0298  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:161:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:92:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x010e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @SuppressLint({"UnusedMaterial3ScaffoldPaddingParameter"})
    /* JADX INFO: renamed from: Z17FullSizeVideoAlbum-PfoAEA0, reason: not valid java name */
    public static final void m10325Z17FullSizeVideoAlbumPfoAEA0(Modifier modifier, VideoAlbumConfiguration videoAlbumConfiguration, final Function1 onVideoSelected, List<AlbumOption> list, VideoAlbumViewModel videoAlbumViewModel, float f10, Function1 function1, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        VideoAlbumConfiguration videoAlbumConfiguration2;
        List<AlbumOption> list2;
        VideoAlbumViewModel videoAlbumViewModel2;
        int i13;
        float f11;
        int i14;
        int i15;
        final Function1 function2;
        int i16;
        boolean z10;
        final float f12;
        final Modifier modifier3;
        final VideoAlbumConfiguration videoAlbumConfiguration3;
        final List<AlbumOption> list3;
        final VideoAlbumViewModel videoAlbumViewModel3;
        final Function1 function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        VideoAlbumConfiguration videoAlbumConfiguration4;
        List<AlbumOption> listN;
        VideoAlbumViewModel videoAlbumViewModel4;
        float fM10290getTenD9Ej5fM;
        final VideoAlbumConfiguration videoAlbumConfiguration5;
        VideoAlbumViewModel videoAlbumViewModel5;
        int i17;
        final float f13;
        Object objRememberedValue;
        VideoAlbumViewModelFactory videoAlbumViewModelFactory;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        final LazyPagingItems lazyPagingItemsCollectAsLazyPagingItems;
        int i18;
        final State stateCollectAsState;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Object obj;
        final VideoAlbumViewModel videoAlbumViewModel6;
        final List<AlbumOption> list4;
        y.i(onVideoSelected, "onVideoSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1197661276);
        int i19 = i11 & 1;
        if (i19 != 0) {
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
                videoAlbumConfiguration2 = videoAlbumConfiguration;
                int i20 = composerStartRestartGroup.changed(videoAlbumConfiguration2) ? 32 : 16;
                i12 |= i20;
            } else {
                videoAlbumConfiguration2 = videoAlbumConfiguration;
            }
            i12 |= i20;
        } else {
            videoAlbumConfiguration2 = videoAlbumConfiguration;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onVideoSelected) ? 256 : 128;
        }
        int i21 = i11 & 8;
        if (i21 == 0) {
            if ((i10 & 3072) == 0) {
                list2 = list;
                i12 |= composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
            }
            if ((i10 & 24576) == 0) {
                if ((i11 & 16) == 0) {
                    videoAlbumViewModel2 = videoAlbumViewModel;
                    int i22 = composerStartRestartGroup.changedInstance(videoAlbumViewModel2) ? 16384 : 8192;
                    i12 |= i22;
                } else {
                    videoAlbumViewModel2 = videoAlbumViewModel;
                }
                i12 |= i22;
            } else {
                videoAlbumViewModel2 = videoAlbumViewModel;
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
                i15 = i11 & 64;
                if (i15 != 0) {
                    i12 |= 1572864;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i10 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i12 |= i16;
                    }
                }
                if ((i12 & 599187) != 599186) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ab.i iVar = null;
                    if ((i10 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if ((i11 & 2) != 0) {
                            videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                            i12 &= -113;
                        } else {
                            videoAlbumConfiguration4 = videoAlbumConfiguration2;
                        }
                        if (i21 != 0) {
                            listN = w.n();
                        } else {
                            listN = list2;
                        }
                        if ((i11 & 16) != 0) {
                            videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                            if (current == null) {
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                            if (current instanceof HasDefaultViewModelProviderFactory) {
                                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                            } else {
                                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                            }
                            ViewModel viewModel = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel;
                            i12 &= -57345;
                        } else {
                            videoAlbumViewModel4 = videoAlbumViewModel2;
                        }
                        if (i13 != 0) {
                            fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                        } else {
                            fM10290getTenD9Ej5fM = f10;
                        }
                        if (i15 != 0) {
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function2 = (Function1) objRememberedValue;
                        }
                        int i23 = i12;
                        videoAlbumConfiguration5 = videoAlbumConfiguration4;
                        videoAlbumViewModel5 = videoAlbumViewModel4;
                        i17 = i23;
                        f13 = fM10290getTenD9Ej5fM;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i11 & 2) != 0) {
                            i12 &= -113;
                        }
                        if ((i11 & 16) != 0) {
                            i12 &= -57345;
                        }
                        List<AlbumOption> list5 = list2;
                        i17 = i12;
                        videoAlbumConfiguration5 = videoAlbumConfiguration2;
                        listN = list5;
                        modifier4 = modifier2;
                        videoAlbumViewModel5 = videoAlbumViewModel2;
                        f13 = f11;
                        iVar = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1197661276, i17, -1, "cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbum (Z17FullSizeVideoAlbum.kt:46)");
                    }
                    LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(videoAlbumViewModel5.getVideos(), iVar, composerStartRestartGroup, 0, 1);
                    i18 = i17;
                    stateCollectAsState = SnapshotStateKt.collectAsState(videoAlbumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                    Modifier modifier5 = modifier4;
                    Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifier5, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                    GridCells.Fixed fixed = new GridCells.Fixed(3);
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(listN);
                    if ((458752 & i18) == 131072) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean zChangedInstance2 = zChangedInstance | z11 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i18 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(videoAlbumConfiguration5)) || (i18 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState);
                    if ((i18 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance3 = zChangedInstance2 | z12 | composerStartRestartGroup.changedInstance(videoAlbumViewModel5);
                    if ((i18 & 3670016) == 1048576) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChangedInstance3 | z13;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        videoAlbumViewModel6 = videoAlbumViewModel5;
                        list4 = listN;
                        obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        obj = objRememberedValue2;
                        videoAlbumViewModel6 = videoAlbumViewModel5;
                        list4 = listN;
                    }
                    Composer composer2 = composerStartRestartGroup;
                    LazyGridDslKt.LazyVerticalGrid(fixed, modifierM1205backgroundbw27NRU$default, lazyGridStateRememberLazyGridState, null, false, null, null, null, false, null, (Function1) obj, composer2, 0, 0, 1016);
                    composerStartRestartGroup = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f12 = f13;
                    videoAlbumConfiguration3 = videoAlbumConfiguration5;
                    videoAlbumViewModel3 = videoAlbumViewModel6;
                    list3 = list4;
                    modifier3 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f12 = f10;
                    modifier3 = modifier2;
                    videoAlbumConfiguration3 = videoAlbumConfiguration2;
                    list3 = list2;
                    videoAlbumViewModel3 = videoAlbumViewModel2;
                }
                function3 = function2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$13(modifier3, videoAlbumConfiguration3, onVideoSelected, list3, videoAlbumViewModel3, f12, function3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f11 = f10;
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i12 |= i16;
                }
            }
            if ((i12 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ab.i iVar2 = null;
                if ((i10 & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        videoAlbumConfiguration4 = videoAlbumConfiguration2;
                    }
                    if (i21 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if ((i11 & 16) != 0) {
                        videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel2 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel2;
                        i12 &= -57345;
                    } else {
                        videoAlbumViewModel4 = videoAlbumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    int i24 = i12;
                    videoAlbumConfiguration5 = videoAlbumConfiguration4;
                    videoAlbumViewModel5 = videoAlbumViewModel4;
                    i17 = i24;
                    f13 = fM10290getTenD9Ej5fM;
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        videoAlbumConfiguration4 = videoAlbumConfiguration2;
                    }
                    if (i21 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if ((i11 & 16) != 0) {
                        videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel3 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel3;
                        i12 &= -57345;
                    } else {
                        videoAlbumViewModel4 = videoAlbumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    int i25 = i12;
                    videoAlbumConfiguration5 = videoAlbumConfiguration4;
                    videoAlbumViewModel5 = videoAlbumViewModel4;
                    i17 = i25;
                    f13 = fM10290getTenD9Ej5fM;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1197661276, i17, -1, "cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbum (Z17FullSizeVideoAlbum.kt:46)");
                }
                LazyGridState lazyGridStateRememberLazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(videoAlbumViewModel5.getVideos(), iVar2, composerStartRestartGroup, 0, 1);
                i18 = i17;
                stateCollectAsState = SnapshotStateKt.collectAsState(videoAlbumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                Modifier modifier6 = modifier4;
                Modifier modifierM1205backgroundbw27NRU$default2 = BackgroundKt.m1205backgroundbw27NRU$default(modifier6, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed2 = new GridCells.Fixed(3);
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(listN);
                if ((458752 & i18) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChangedInstance5 = zChangedInstance4 | z11 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i18 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(videoAlbumConfiguration5)) || (i18 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState);
                if ((i18 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance6 = zChangedInstance5 | z12 | composerStartRestartGroup.changedInstance(videoAlbumViewModel5);
                if ((i18 & 3670016) == 1048576) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChangedInstance6 | z13;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    videoAlbumViewModel6 = videoAlbumViewModel5;
                    list4 = listN;
                    obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    videoAlbumViewModel6 = videoAlbumViewModel5;
                    list4 = listN;
                    obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                Composer composer3 = composerStartRestartGroup;
                LazyGridDslKt.LazyVerticalGrid(fixed2, modifierM1205backgroundbw27NRU$default2, lazyGridStateRememberLazyGridState2, null, false, null, null, null, false, null, (Function1) obj, composer3, 0, 0, 1016);
                composerStartRestartGroup = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                videoAlbumConfiguration3 = videoAlbumConfiguration5;
                videoAlbumViewModel3 = videoAlbumViewModel6;
                list3 = list4;
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f10;
                modifier3 = modifier2;
                videoAlbumConfiguration3 = videoAlbumConfiguration2;
                list3 = list2;
                videoAlbumViewModel3 = videoAlbumViewModel2;
            }
            function3 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$13(modifier3, videoAlbumConfiguration3, onVideoSelected, list3, videoAlbumViewModel3, f12, function3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i12 |= 3072;
        list2 = list;
        if ((i10 & 24576) == 0) {
            if ((i11 & 16) == 0) {
                videoAlbumViewModel2 = videoAlbumViewModel;
                if (composerStartRestartGroup.changedInstance(videoAlbumViewModel2)) {
                }
                i12 |= i22;
            } else {
                videoAlbumViewModel2 = videoAlbumViewModel;
            }
            i12 |= i22;
        } else {
            videoAlbumViewModel2 = videoAlbumViewModel;
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
            i15 = i11 & 64;
            if (i15 != 0) {
                i12 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i10 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i12 |= i16;
                }
            }
            if ((i12 & 599187) != 599186) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ab.i iVar3 = null;
                if ((i10 & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        videoAlbumConfiguration4 = videoAlbumConfiguration2;
                    }
                    if (i21 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if ((i11 & 16) != 0) {
                        videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel4 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel4;
                        i12 &= -57345;
                    } else {
                        videoAlbumViewModel4 = videoAlbumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    int i26 = i12;
                    videoAlbumConfiguration5 = videoAlbumConfiguration4;
                    videoAlbumViewModel5 = videoAlbumViewModel4;
                    i17 = i26;
                    f13 = fM10290getTenD9Ej5fM;
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i11 & 2) != 0) {
                        videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                        i12 &= -113;
                    } else {
                        videoAlbumConfiguration4 = videoAlbumConfiguration2;
                    }
                    if (i21 != 0) {
                        listN = w.n();
                    } else {
                        listN = list2;
                    }
                    if ((i11 & 16) != 0) {
                        videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                        }
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel5 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel5;
                        i12 &= -57345;
                    } else {
                        videoAlbumViewModel4 = videoAlbumViewModel2;
                    }
                    if (i13 != 0) {
                        fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                    } else {
                        fM10290getTenD9Ej5fM = f10;
                    }
                    if (i15 != 0) {
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function2 = (Function1) objRememberedValue;
                    }
                    int i27 = i12;
                    videoAlbumConfiguration5 = videoAlbumConfiguration4;
                    videoAlbumViewModel5 = videoAlbumViewModel4;
                    i17 = i27;
                    f13 = fM10290getTenD9Ej5fM;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1197661276, i17, -1, "cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbum (Z17FullSizeVideoAlbum.kt:46)");
                }
                LazyGridState lazyGridStateRememberLazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(videoAlbumViewModel5.getVideos(), iVar3, composerStartRestartGroup, 0, 1);
                i18 = i17;
                stateCollectAsState = SnapshotStateKt.collectAsState(videoAlbumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
                Modifier modifier7 = modifier4;
                Modifier modifierM1205backgroundbw27NRU$default3 = BackgroundKt.m1205backgroundbw27NRU$default(modifier7, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
                GridCells.Fixed fixed3 = new GridCells.Fixed(3);
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(listN);
                if ((458752 & i18) == 131072) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean zChangedInstance8 = zChangedInstance7 | z11 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i18 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(videoAlbumConfiguration5)) || (i18 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState);
                if ((i18 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance9 = zChangedInstance8 | z12 | composerStartRestartGroup.changedInstance(videoAlbumViewModel5);
                if ((i18 & 3670016) == 1048576) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChangedInstance9 | z13;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    videoAlbumViewModel6 = videoAlbumViewModel5;
                    list4 = listN;
                    obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    videoAlbumViewModel6 = videoAlbumViewModel5;
                    list4 = listN;
                    obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                Composer composer4 = composerStartRestartGroup;
                LazyGridDslKt.LazyVerticalGrid(fixed3, modifierM1205backgroundbw27NRU$default3, lazyGridStateRememberLazyGridState3, null, false, null, null, null, false, null, (Function1) obj, composer4, 0, 0, 1016);
                composerStartRestartGroup = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f12 = f13;
                videoAlbumConfiguration3 = videoAlbumConfiguration5;
                videoAlbumViewModel3 = videoAlbumViewModel6;
                list3 = list4;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f12 = f10;
                modifier3 = modifier2;
                videoAlbumConfiguration3 = videoAlbumConfiguration2;
                list3 = list2;
                videoAlbumViewModel3 = videoAlbumViewModel2;
            }
            function3 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$13(modifier3, videoAlbumConfiguration3, onVideoSelected, list3, videoAlbumViewModel3, f12, function3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f11 = f10;
        i15 = i11 & 64;
        if (i15 != 0) {
            i12 |= 1572864;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i10 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i12 |= i16;
            }
        }
        if ((i12 & 599187) != 599186) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z10, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ab.i iVar4 = null;
            if ((i10 & 1) != 0) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                    i12 &= -113;
                } else {
                    videoAlbumConfiguration4 = videoAlbumConfiguration2;
                }
                if (i21 != 0) {
                    listN = w.n();
                } else {
                    listN = list2;
                }
                if ((i11 & 16) != 0) {
                    videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel6 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel6;
                    i12 &= -57345;
                } else {
                    videoAlbumViewModel4 = videoAlbumViewModel2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f10;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function2 = (Function1) objRememberedValue;
                }
                int i28 = i12;
                videoAlbumConfiguration5 = videoAlbumConfiguration4;
                videoAlbumViewModel5 = videoAlbumViewModel4;
                i17 = i28;
                f13 = fM10290getTenD9Ej5fM;
            } else {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i11 & 2) != 0) {
                    videoAlbumConfiguration4 = new VideoAlbumConfiguration(false, 1, null);
                    i12 &= -113;
                } else {
                    videoAlbumConfiguration4 = videoAlbumConfiguration2;
                }
                if (i21 != 0) {
                    listN = w.n();
                } else {
                    listN = list2;
                }
                if ((i11 & 16) != 0) {
                    videoAlbumViewModelFactory = new VideoAlbumViewModelFactory(new VideoRepository((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel7 = ViewModelKt.viewModel(z0.b(VideoAlbumViewModel.class), current, "1", videoAlbumViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    videoAlbumViewModel4 = (VideoAlbumViewModel) viewModel7;
                    i12 &= -57345;
                } else {
                    videoAlbumViewModel4 = videoAlbumViewModel2;
                }
                if (i13 != 0) {
                    fM10290getTenD9Ej5fM = AlbumDimens.INSTANCE.m10290getTenD9Ej5fM();
                } else {
                    fM10290getTenD9Ej5fM = f10;
                }
                if (i15 != 0) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: cu.z17.views.videosAlbum.ui.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0((String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function2 = (Function1) objRememberedValue;
                }
                int i29 = i12;
                videoAlbumConfiguration5 = videoAlbumConfiguration4;
                videoAlbumViewModel5 = videoAlbumViewModel4;
                i17 = i29;
                f13 = fM10290getTenD9Ej5fM;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1197661276, i17, -1, "cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbum (Z17FullSizeVideoAlbum.kt:46)");
            }
            LazyGridState lazyGridStateRememberLazyGridState4 = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
            lazyPagingItemsCollectAsLazyPagingItems = LazyPagingItemsKt.collectAsLazyPagingItems(videoAlbumViewModel5.getVideos(), iVar4, composerStartRestartGroup, 0, 1);
            i18 = i17;
            stateCollectAsState = SnapshotStateKt.collectAsState(videoAlbumViewModel5.getSelectedList().getValue(), w.n(), null, composerStartRestartGroup, 48, 2);
            Modifier modifier8 = modifier4;
            Modifier modifierM1205backgroundbw27NRU$default4 = BackgroundKt.m1205backgroundbw27NRU$default(modifier8, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            GridCells.Fixed fixed4 = new GridCells.Fixed(3);
            boolean zChangedInstance10 = composerStartRestartGroup.changedInstance(listN);
            if ((458752 & i18) == 131072) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean zChangedInstance11 = zChangedInstance10 | z11 | composerStartRestartGroup.changedInstance(lazyPagingItemsCollectAsLazyPagingItems) | ((((i18 & 112) ^ 48) <= 32 && composerStartRestartGroup.changed(videoAlbumConfiguration5)) || (i18 & 48) == 32) | composerStartRestartGroup.changed(stateCollectAsState);
            if ((i18 & 896) == 256) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean zChangedInstance12 = zChangedInstance11 | z12 | composerStartRestartGroup.changedInstance(videoAlbumViewModel5);
            if ((i18 & 3670016) == 1048576) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = zChangedInstance12 | z13;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z14) {
                videoAlbumViewModel6 = videoAlbumViewModel5;
                list4 = listN;
                obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                videoAlbumViewModel6 = videoAlbumViewModel5;
                list4 = listN;
                obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(list4, lazyPagingItemsCollectAsLazyPagingItems, f13, videoAlbumConfiguration5, onVideoSelected, stateCollectAsState, videoAlbumViewModel6, function2, (LazyGridScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            }
            Composer composer5 = composerStartRestartGroup;
            LazyGridDslKt.LazyVerticalGrid(fixed4, modifierM1205backgroundbw27NRU$default4, lazyGridStateRememberLazyGridState4, null, false, null, null, null, false, null, (Function1) obj, composer5, 0, 0, 1016);
            composerStartRestartGroup = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f12 = f13;
            videoAlbumConfiguration3 = videoAlbumConfiguration5;
            videoAlbumViewModel3 = videoAlbumViewModel6;
            list3 = list4;
            modifier3 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f12 = f10;
            modifier3 = modifier2;
            videoAlbumConfiguration3 = videoAlbumConfiguration2;
            list3 = list2;
            videoAlbumViewModel3 = videoAlbumViewModel2;
        }
        function3 = function2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videosAlbum.ui.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$13(modifier3, videoAlbumConfiguration3, onVideoSelected, list3, videoAlbumViewModel3, f12, function3, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Z17FullSizeVideoAlbum_PfoAEA0$lambda$1$lambda$0(String it) {
        y.i(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11(List list, final LazyPagingItems lazyPagingItems, final float f10, final VideoAlbumConfiguration videoAlbumConfiguration, final Function1 function1, final State state, final VideoAlbumViewModel videoAlbumViewModel, final Function1 function2, LazyGridScope LazyVerticalGrid) {
        y.i(LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyVerticalGrid.items(list.size(), null, null, new Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$3(list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$4(list, f10)));
        LazyGridScope.CC.b(LazyVerticalGrid, lazyPagingItems.getItemCount(), null, null, null, ComposableLambdaKt.composableLambdaInstance(2114694825, true, new lb.o() { // from class: cu.z17.views.videosAlbum.ui.j
            @Override // lb.o
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10(lazyPagingItems, videoAlbumConfiguration, function1, state, videoAlbumViewModel, f10, function2, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 14, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10(LazyPagingItems lazyPagingItems, final VideoAlbumConfiguration videoAlbumConfiguration, final Function1 function1, final State state, final VideoAlbumViewModel videoAlbumViewModel, float f10, Function1 function2, LazyGridItemScope items, int i10, Composer composer, int i11) {
        int i12;
        y.i(items, "$this$items");
        if ((i11 & 48) == 0) {
            i12 = i11 | (composer.changed(i10) ? 32 : 16);
        } else {
            i12 = i11;
        }
        if (composer.shouldExecute((i12 & 145) != 144, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2114694825, i12, -1, "cu.z17.views.videosAlbum.ui.Z17FullSizeVideoAlbum.<anonymous>.<anonymous>.<anonymous> (Z17FullSizeVideoAlbum.kt:79)");
            }
            final VideoAlbum videoAlbum = (VideoAlbum) lazyPagingItems.get(i10);
            if (videoAlbum == null) {
                composer.startReplaceGroup(293312433);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(293312434);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(Modifier.INSTANCE, VideoAlbumDimens.INSTANCE.m10315getHalfQuarterD9Ej5fM());
                boolean multipleVideosAllowed = videoAlbumConfiguration.getMultipleVideosAllowed();
                boolean zContains = Z17FullSizeVideoAlbum_PfoAEA0$lambda$2(state).contains(videoAlbum);
                boolean zChanged = composer.changed(videoAlbumConfiguration) | composer.changed(function1) | composer.changed(state) | composer.changedInstance(videoAlbum) | composer.changedInstance(videoAlbumViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: cu.z17.views.videosAlbum.ui.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(videoAlbumConfiguration, function1, videoAlbum, videoAlbumViewModel, state, (VideoAlbum) obj2);
                        }
                    };
                    videoAlbum = videoAlbum;
                    composer.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                VideoCommonKt.m10324AlbumVideoItemPfoAEA0(modifierM1725padding3ABfNKs, videoAlbum, multipleVideosAllowed, zContains, (Function1) objRememberedValue, f10, function2, composer, 6, 0);
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
    public static final k0 Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(VideoAlbumConfiguration videoAlbumConfiguration, Function1 function1, VideoAlbum videoAlbum, VideoAlbumViewModel videoAlbumViewModel, State state, final VideoAlbum video) {
        y.i(video, "video");
        if (!videoAlbumConfiguration.getMultipleVideosAllowed()) {
            function1.invoke(w.g(video));
        } else if (Z17FullSizeVideoAlbum_PfoAEA0$lambda$2(state).contains(videoAlbum)) {
            function1.invoke(videoAlbumViewModel.getSelectedList().removeAll(new Function1() { // from class: cu.z17.views.videosAlbum.ui.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Z17FullSizeVideoAlbumKt.Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(video, (VideoAlbum) obj));
                }
            }));
        } else {
            function1.invoke(videoAlbumViewModel.getSelectedList().add(videoAlbum));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(VideoAlbum videoAlbum, VideoAlbum it) {
        y.i(it, "it");
        return y.d(it.getId$views_release(), videoAlbum.getId$views_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 Z17FullSizeVideoAlbum_PfoAEA0$lambda$13(Modifier modifier, VideoAlbumConfiguration videoAlbumConfiguration, Function1 function1, List list, VideoAlbumViewModel videoAlbumViewModel, float f10, Function1 function2, int i10, int i11, Composer composer, int i12) {
        m10325Z17FullSizeVideoAlbumPfoAEA0(modifier, videoAlbumConfiguration, function1, list, videoAlbumViewModel, f10, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    private static final List<VideoAlbum> Z17FullSizeVideoAlbum_PfoAEA0$lambda$2(State<? extends List<VideoAlbum>> state) {
        return state.getValue();
    }
}
