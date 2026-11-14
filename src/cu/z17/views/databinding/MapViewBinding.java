package cu.z17.views.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import cu.z17.views.R;
import org.osmdroid.views.MapView;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
public final class MapViewBinding implements ViewBinding {

    @NonNull
    public final MapView map;

    @NonNull
    private final MapView rootView;

    private MapViewBinding(@NonNull MapView mapView, @NonNull MapView mapView2) {
        this.rootView = mapView;
        this.map = mapView2;
    }

    @NonNull
    public static MapViewBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        MapView mapView = (MapView) view;
        return new MapViewBinding(mapView, mapView);
    }

    @NonNull
    public static MapViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MapViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.map_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MapView getRoot() {
        return this.rootView;
    }
}
