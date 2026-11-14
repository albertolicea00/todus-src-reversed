package cu.todus.android.data.geo;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import va.v;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcu/todus/android/data/geo/CubaGeoDataSource;", "", "<init>", "()V", "fullData", "", "Lcu/todus/android/data/geo/Province;", "getFullData", "()Ljava/util/List;", "getProvinceNameById", "", "id", "getMunicipalityNameById", "municipalityId", "getPositionById", "", "getPositionOfMunicipalityById", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CubaGeoDataSource {
    public static final int $stable = 8;
    private final List<Province> fullData = w.q(new Province("1", "Pinar del Río", w.q("Consolación del Sur", "Guane", "La Palma", "Los Palacios", "Mantua", "Minas de Matahambre", "Pinar del Río", "San Juan y Martínez", "San Luis", "Sandino", "Viñales")), new Province(ExifInterface.GPS_MEASUREMENT_2D, "Artemisa", w.q("Alquízar", "Artemisa", "Bauta", "Caimito", "Guanajay", "Güira de Melena", "Mariel", "San Antonio de los Baños", "Bahía Honda", "San Cristóbal", "Candelaria")), new Province(ExifInterface.GPS_MEASUREMENT_3D, "Mayabeque", w.q("Batabanó", "Bejucal", "Güines", "Jaruco", "Madruga", "Melena del Sur", "Nueva Paz", "Quivicán", "San José de las Lajas", "San Nicolás de Bari", "Santa Cruz del Norte")), new Province("4", "La Habana", w.q("Arroyo Naranjo", "Boyeros", "Centro Habana", "Cerro", "Cotorro", "Diez de Octubre", "Guanabacoa", "Habana del Este", "Habana Vieja", "La Lisa", "Marianao", "Playa", "Plaza", "Regla", "San Miguel del Padrón")), new Province("5", "Matanzas", w.q("Calimete", "Cárdenas", "Ciénaga de Zapata", "Colón", "Jagüey Grande", "Jovellanos", "Limonar", "Los Arabos", "Martí", "Matanzas", "Pedro Betancourt", "Perico", "Unión de Reyes")), new Province("6", "Cienfuegos", w.q("Abreus", "Aguada de Pasajeros", "Cienfuegos", "Cruces", "Cumanayagua", "Palmira", "Rodas", "Santa Isabel de las Lajas")), new Province("7", "Villa Clara", w.q("Caibarién", "Camajuaní", "Cifuentes", "Corralillo", "Encrucijada", "Manicaragua", "Placetas", "Quemado de Güines", "Ranchuelo", "Remedios", "Sagua la Grande", "Santa Clara", "Santo Domingo")), new Province("8", "Sancti Spíritus", w.q("Cabaigúan", "Fomento", "Jatibonico", "La Sierpe", "Sancti Spíritus", "Taguasco", "Trinidad", "Yaguajay")), new Province("9", "Ciego de Ávila", w.q("Ciro Redondo", "Baraguá", "Bolivia", "Chambas", "Ciego de Ávila", "Florencia", "Majagua", "Morón", "Primero de Enero", "Venezuela")), new Province("10", "Camagüey", w.q("Camagüey", "Carlos Manuel de Céspedes", "Esmeralda", "Florida", "Guaimaro", "Jimagüayú", "Minas", "Najasa", "Nuevitas", "Santa Cruz del Sur", "Sibanicú", "Sierra de Cubitas", "Vertientes")), new Province("11", "Las Tunas", w.q("Amancio Rodríguez", "Colombia", "Jesús Menéndez", "Jobabo", "Las Tunas", "Majibacoa", "Manatí", "Puerto Padre")), new Province("12", "Holguín", w.q("Antilla", "Báguanos", "Banes", "Cacocum", "Calixto García", "Cueto", "Frank País", "Gibara", "Holguín", "Mayarí", "Moa", "Rafael Freyre", "Sagua de Tánamo", "Urbano Noris")), new Province("13", "Santiago de Cuba", w.q("Contramaestre", "Guamá", "Julio Antonio Mella", "Palma Soriano", "San Luis", "Santiago de Cuba", "Segundo Frente", "Songo la Maya", "Tercer Frente")), new Province("14", "Guantánamo", w.q("Baracoa", "Caimanera", "El Salvador", "Guantánamo", "Imías", "Maisí", "Manuel Tames", "Niceto Pérez", "San Antonio del Sur", "Yateras")), new Province("15", "Isla de la Juventud", v.e("Isla de la Juventud")), new Province("16", "Granma", w.q("Bartolomé Masó", "Bayamo", "Buey Arriba", "Campechuela", "Cauto Cristo", "Guisa", "Jiguaní", "Manzanillo", "Media Luna", "Niquero", "Pilón", "Río Cauto", "Yara")));

    public final List<Province> getFullData() {
        return this.fullData;
    }

    public final String getMunicipalityNameById(String id2, String municipalityId) {
        y.i(id2, "id");
        y.i(municipalityId, "municipalityId");
        return this.fullData.get(getPositionById(id2)).getMunicipalities().get(getPositionOfMunicipalityById(id2, municipalityId));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x002c A[RETURN] */
    public final int getPositionById(String id2) {
        y.i(id2, "id");
        Iterator<Province> it = this.fullData.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (y.d(it.next().getId(), id2)) {
                if (i10 == -1) {
                    return 0;
                }
                return i10;
            }
            i10++;
        }
        i10 = -1;
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    public final int getPositionOfMunicipalityById(String id2, String municipalityId) {
        y.i(id2, "id");
        y.i(municipalityId, "municipalityId");
        Iterator<String> it = this.fullData.get(getPositionById(id2)).getMunicipalities().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (y.d(it.next(), municipalityId)) {
                if (i10 == -1) {
                    return 0;
                }
                return i10;
            }
            i10++;
        }
        i10 = -1;
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    public final String getProvinceNameById(String id2) {
        y.i(id2, "id");
        return this.fullData.get(getPositionById(id2)).getName();
    }
}
