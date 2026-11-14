package cu.todus.android.uiCompose.main.screen.search;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import kotlin.Metadata;
import te.p0;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u0007008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/search/SearchViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", Room.COLUMN_LAST_MSG, "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "getMsgById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "chatMsgs", "(Ljava/lang/String;)Lte/h;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "getOpenRooms", "s", "Lua/k0;", "setNewFilterValue", "(Ljava/lang/String;)V", "roomId", "", "getMsgPosition", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Landroidx/paging/PagingConfig;", "pagerConfigs", "Landroidx/paging/PagingConfig;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "_filterValue", "Lte/b0;", "Lte/p0;", "filterValue", "Lte/p0;", "getFilterValue", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.b0 _filterValue;
    private final p0 filterValue;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final RoomsRepository roomsRepository = RoomsRepository.INSTANCE.getInstance();
    private final StatusRepository statusRepository = StatusRepository.INSTANCE.getInstance();
    private final PagingConfig pagerConfigs = new PagingConfig(20, 20, true, 40, Integer.MAX_VALUE, 0, 32, null);
    private final v5.f gson = MainModule.INSTANCE.getInstance().getGson();

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$getMsgPosition$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchViewModel", f = "SearchViewModel.kt", l = {WebmConstants.MkvEbmlElement.PIXEL_HEIGHT}, m = "getMsgPosition", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchViewModel.this.getMsgPosition(null, null, this);
        }
    }

    public SearchViewModel() {
        te.b0 b0VarA = r0.a("");
        this._filterValue = b0VarA;
        this.filterValue = te.j.b(b0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource chatMsgs$lambda$0(SearchViewModel searchViewModel, String str) {
        return searchViewModel.roomsRepository.getMsgsByFilterForPaging(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource getOpenRooms$lambda$0(SearchViewModel searchViewModel, String str) {
        return searchViewModel.roomsRepository.getOPenRooms(str);
    }

    public final te.h chatMsgs(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        final te.h hVarF = te.j.f(new Pager(this.pagerConfigs, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.e0
            @Override // lb.a
            public final Object invoke() {
                return SearchViewModel.chatMsgs$lambda$0(this.f27352c, filter);
            }
        }, 2, null).getFlow());
        final te.h hVar = new te.h() { // from class: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$1$2", f = "SearchViewModel.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        ua.v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData pagingDataInsertSeparators$default = PagingDataTransforms__PagingDataTransformsKt.insertSeparators$default((PagingData) obj, null, new SearchViewModel$chatMsgs$2$1(null), 1, null);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(pagingDataInsertSeparators$default, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarF.collect(new AnonymousClass2(iVar), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
        final te.h hVar2 = new te.h() { // from class: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$2

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$2$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$2$2", f = "SearchViewModel.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        ua.v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData pagingDataInsertSeparators$default = PagingDataTransforms__PagingDataTransformsKt.insertSeparators$default((PagingData) obj, null, new SearchViewModel$chatMsgs$3$1(null), 1, null);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(pagingDataInsertSeparators$default, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVar.collect(new AnonymousClass2(iVar), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        };
        return CachedPagingDataKt.cachedIn(new te.h() { // from class: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$3

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ SearchViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$3$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.search.SearchViewModel$chatMsgs$$inlined$map$3$2", f = "SearchViewModel.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(ab.e eVar) {
                        super(eVar);
                    }

                    @Override // cb.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(te.i iVar, SearchViewModel searchViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = searchViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    if (eVar instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) eVar;
                        int i10 = anonymousClass1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i10 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(eVar);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(eVar);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objG = bb.b.g();
                    int i11 = anonymousClass1.label;
                    if (i11 == 0) {
                        ua.v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new SearchViewModel$chatMsgs$4$1(this.this$0, null));
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVar2.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    public final p0 getFilterValue() {
        return this.filterValue;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final Object getMsgById(String str, ab.e<? super MessageWithPartnerWithReactions> eVar) {
        return this.mainRepository.getMsgById(str, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getMsgPosition(String str, String str2, ab.e<? super Integer> eVar) {
        AnonymousClass1 anonymousClass1;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object msgPosition = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(msgPosition);
            RoomsRepository roomsRepository = this.roomsRepository;
            anonymousClass1.L$0 = cb.l.a(str);
            anonymousClass1.L$1 = str2;
            anonymousClass1.label = 1;
            msgPosition = roomsRepository.getMsgPosition(str, str2, anonymousClass1);
            if (msgPosition == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass1.L$1;
            ua.v.b(msgPosition);
        }
        int iIntValue = ((Number) msgPosition).intValue();
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.showReply(str2);
        }
        return cb.b.d(iIntValue);
    }

    public final te.h getOpenRooms(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagerConfigs, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.search.d0
            @Override // lb.a
            public final Object invoke() {
                return SearchViewModel.getOpenRooms$lambda$0(this.f27350c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void setNewFilterValue(String s10) {
        kotlin.jvm.internal.y.i(s10, "s");
        this._filterValue.setValue(s10);
    }
}
