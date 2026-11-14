package cu.z17.views.picturesAlbum.data;

import ab.e;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import bb.b;
import cb.d;
import cb.f;
import cb.m;
import cu.z17.views.picturesAlbum.util.MediaLoaderKt;
import cu.z17.views.utils.galleryUtility.GalleryImage;
import cu.z17.views.utils.galleryUtility.interactor.GalleryPicker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.z;
import ua.k0;
import ua.v;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcu/z17/views/picturesAlbum/data/ImageRepository;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getCount", "(Lab/e;)Ljava/lang/Object;", "offset", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "getByOffset", "(ILab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "getPicturePagingSource", "()Landroidx/paging/PagingSource;", "Landroid/content/Context;", "Lcu/z17/views/utils/galleryUtility/interactor/GalleryPicker;", "galleryPicker", "Lcu/z17/views/utils/galleryUtility/interactor/GalleryPicker;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageRepository {
    public static final int $stable = 8;
    private final Context context;
    private final GalleryPicker galleryPicker;

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.data.ImageRepository$getByOffset$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.data.ImageRepository", f = "AlbumRepository.kt", l = {25}, m = "getByOffset")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageRepository.this.getByOffset(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.data.ImageRepository$getCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.data.ImageRepository", f = "AlbumRepository.kt", l = {18}, m = "getCount")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15311 extends d {
        int label;
        /* synthetic */ Object result;

        public C15311(e<? super C15311> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageRepository.this.getCount(this);
        }
    }

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.data.ImageRepository$getPicturePagingSource$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.data.ImageRepository$getPicturePagingSource$1", f = "AlbumRepository.kt", l = {30}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "limit", "", "offset"}, k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class C15321 extends m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int label;

        public C15321(e<? super C15321> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, int i11, e<? super List<AlbumImage>> eVar) {
            C15321 c15321 = ImageRepository.this.new C15321(eVar);
            c15321.I$0 = i10;
            c15321.I$1 = i11;
            return c15321.invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = b.g();
            int i12 = this.label;
            if (i12 == 0) {
                v.b(obj);
                GalleryPicker galleryPicker = ImageRepository.this.galleryPicker;
                this.I$0 = i10;
                this.I$1 = i11;
                this.label = 1;
                obj = galleryPicker.getImages(i10, i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            ArrayList arrayList = new ArrayList();
            for (GalleryImage galleryImage : (Iterable) obj) {
                AlbumImage albumImage = null;
                try {
                    Uri uri = Uri.parse(galleryImage.getDATA());
                    y.h(uri, "parse(...)");
                    String date_added = galleryImage.getDATE_ADDED();
                    Long lX = date_added != null ? z.x(date_added) : null;
                    String display_name = galleryImage.getDISPLAY_NAME();
                    String id2 = galleryImage.getID();
                    albumImage = new AlbumImage(uri, lX, display_name, id2 != null ? z.x(id2) : null, galleryImage.getALBUM_NAME());
                } catch (Exception unused) {
                }
                if (albumImage != null) {
                    arrayList.add(albumImage);
                }
            }
            return arrayList;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (e<? super List<AlbumImage>>) obj3);
        }
    }

    public ImageRepository(Context context) {
        y.i(context, "context");
        this.context = context;
        this.galleryPicker = new GalleryPicker(context);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getByOffset(int i10, e<? super AlbumImage> eVar) {
        AnonymousClass1 anonymousClass1;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objFetchPagePicture = anonymousClass1.result;
        Object objG = b.g();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            v.b(objFetchPagePicture);
            Context context = this.context;
            anonymousClass1.I$0 = i10;
            anonymousClass1.label = 1;
            objFetchPagePicture = MediaLoaderKt.fetchPagePicture(context, 1, i10, anonymousClass1);
            if (objFetchPagePicture == objG) {
                return objG;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objFetchPagePicture);
        }
        return g0.y0((List) objFetchPagePicture);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getCount(e<? super Integer> eVar) {
        C15311 c15311;
        if (eVar instanceof C15311) {
            c15311 = (C15311) eVar;
            int i10 = c15311.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15311.label = i10 - Integer.MIN_VALUE;
            } else {
                c15311 = new C15311(eVar);
            }
        } else {
            c15311 = new C15311(eVar);
        }
        Object objCreateCursor = c15311.result;
        Object objG = b.g();
        int i11 = c15311.label;
        if (i11 == 0) {
            v.b(objCreateCursor);
            Context context = this.context;
            c15311.label = 1;
            objCreateCursor = MediaLoaderKt.createCursor(context, Integer.MAX_VALUE, 0, c15311);
            if (objCreateCursor == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objCreateCursor);
        }
        Cursor cursor = (Cursor) objCreateCursor;
        if (cursor == null) {
            return cb.b.d(0);
        }
        int count = cursor.getCount();
        cursor.close();
        return cb.b.d(count);
    }

    public final PagingSource<Integer, AlbumImage> getPicturePagingSource() {
        return new AlbumDataSource(new C15321(null));
    }
}
