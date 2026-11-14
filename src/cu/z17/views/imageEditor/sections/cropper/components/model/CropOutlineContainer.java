package cu.z17.views.imageEditor.sections.cropper.components.model;

import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import i9.a;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "O", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "", "selectedIndex", "", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "outlines", "", "getOutlines", "()Ljava/util/List;", "selectedItem", "getSelectedItem", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "size", "getSize", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CropOutlineContainer<O extends CropOutline> {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <O extends CropOutline> O getSelectedItem(CropOutlineContainer<O> cropOutlineContainer) {
            return (O) a.a(cropOutlineContainer);
        }

        @Deprecated
        public static <O extends CropOutline> int getSize(CropOutlineContainer<O> cropOutlineContainer) {
            return a.b(cropOutlineContainer);
        }
    }

    List<O> getOutlines();

    int getSelectedIndex();

    O getSelectedItem();

    int getSize();

    void setSelectedIndex(int i10);
}
