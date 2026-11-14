package cu.todus.android.image;

import ab.e;
import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.repositories.AuthRepository;
import cu.todus.android.rest.TokenAuthenticator;
import cu.z17.views.utils.Z17CoilDecoders;
import cu.z17.views.utils.Z17InlineUtilsKt;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.d0;
import pe.d1;
import pe.i;
import pe.j;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcu/todus/android/image/ImageLoader;", "", "<init>", "()V", "getCircleImage", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "imageToLoad", "", "placeholderOrError", "color", "", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ImageLoader {
    public static final int $stable = 0;
    public static final ImageLoader INSTANCE = new ImageLoader();

    /* JADX INFO: renamed from: cu.todus.android.image.ImageLoader$getCircleImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.image.ImageLoader$getCircleImage$1", f = "ImageLoader.kt", l = {45}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ String $imageToLoad;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.image.ImageLoader$getCircleImage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.todus.android.image.ImageLoader$getCircleImage$1$1", f = "ImageLoader.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lpe/m0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 3, 0})
        public static final class C02011 extends m implements Function2 {
            final /* synthetic */ String $imageToLoad;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02011(String str, e<? super C02011> eVar) {
                super(2, eVar);
                this.$imageToLoad = str;
            }

            @Override // cb.a
            public final e<k0> create(Object obj, e<?> eVar) {
                return new C02011(this.$imageToLoad, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                String token;
                Owner owner;
                b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                try {
                    AuthRepository instanceOrNull = AuthRepository.INSTANCE.getInstanceOrNull();
                    if (instanceOrNull == null || (owner = instanceOrNull.getOwner()) == null || (token = owner.getToken()) == null) {
                        token = "";
                    }
                    URLConnection uRLConnectionOpenConnection = new URL(this.$imageToLoad).openConnection();
                    y.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("User-Agent", "ToDus 2.1.2 Pictures");
                    httpURLConnection.setRequestProperty(TokenAuthenticator.AUTHORIZATION, "Bearer " + token);
                    httpURLConnection.connect();
                    return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                } catch (IOException unused) {
                    return null;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, e<? super Bitmap> eVar) {
                return ((C02011) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$imageToLoad = str;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass1(this.$imageToLoad, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            pe.k0 k0VarB = d1.b();
            C02011 c02011 = new C02011(this.$imageToLoad, null);
            this.label = 1;
            Object objG2 = i.g(k0VarB, c02011, this);
            return objG2 == objG ? objG : objG2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super Bitmap> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    private ImageLoader() {
    }

    public static /* synthetic */ Bitmap getCircleImage$default(ImageLoader imageLoader, Context context, String str, String str2, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i10 & 8) != 0) {
            j10 = Color.parseColor("#9c9c9c");
        }
        long j11 = j10;
        if ((i10 & 16) != 0) {
            z10 = true;
        }
        return imageLoader.getCircleImage(context, str, str3, j11, z10);
    }

    public final Bitmap getCircleImage(Context context, String imageToLoad, String placeholderOrError, long color, boolean circle) {
        Exception exc;
        y.i(context, "context");
        y.i(imageToLoad, "imageToLoad");
        y.i(placeholderOrError, "placeholderOrError");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_width);
        Bitmap bitmapCreateScaledBitmap = null;
        try {
            Z17CoilDecoders instanceOrNull = Z17CoilDecoders.INSTANCE.getInstanceOrNull();
            Bitmap inCache$default = instanceOrNull != null ? Z17CoilDecoders.getInCache$default(instanceOrNull, imageToLoad, null, 2, null) : null;
            try {
                if (inCache$default != null) {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(inCache$default, dimensionPixelSize, dimensionPixelSize, false);
                } else if (!d0.q0(imageToLoad)) {
                    bitmapCreateScaledBitmap = (Bitmap) j.b(null, new AnonymousClass1(imageToLoad, null), 1, null);
                }
            } catch (Exception e10) {
                exc = e10;
                bitmapCreateScaledBitmap = inCache$default;
                exc.printStackTrace();
            }
        } catch (Exception e11) {
            exc = e11;
        }
        return bitmapCreateScaledBitmap == null ? Z17InlineUtilsKt.asBitmap(placeholderOrError, color, dimensionPixelSize, dimensionPixelSize, circle) : bitmapCreateScaledBitmap;
    }
}
