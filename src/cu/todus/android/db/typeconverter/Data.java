package cu.todus.android.db.typeconverter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.room.TypeConverter;
import j$.util.DesugarCollections;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public final class Data {
    public static final Data EMPTY = new Builder().build();
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = "Data";
    Map<String, Object> mValues;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static final class Builder {
        private final Map<String, Object> mValues = new HashMap();

        @NonNull
        public Data build() {
            return new Data(this.mValues);
        }

        @NonNull
        public Builder putAll(@NonNull Data data) {
            putAll(data.mValues);
            return this;
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z10) {
            this.mValues.put(str, Boolean.valueOf(z10));
            return this;
        }

        @NonNull
        public Builder putBooleanArray(@NonNull String str, boolean[] zArr) {
            this.mValues.put(str, Data.convertPrimitiveBooleanArray(zArr));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d10) {
            this.mValues.put(str, Double.valueOf(d10));
            return this;
        }

        @NonNull
        public Builder putDoubleArray(@NonNull String str, double[] dArr) {
            this.mValues.put(str, Data.convertPrimitiveDoubleArray(dArr));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f10) {
            this.mValues.put(str, Float.valueOf(f10));
            return this;
        }

        @NonNull
        public Builder putFloatArray(String str, float[] fArr) {
            this.mValues.put(str, Data.convertPrimitiveFloatArray(fArr));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i10) {
            this.mValues.put(str, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public Builder putIntArray(@NonNull String str, int[] iArr) {
            this.mValues.put(str, Data.convertPrimitiveIntArray(iArr));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j10) {
            this.mValues.put(str, Long.valueOf(j10));
            return this;
        }

        @NonNull
        public Builder putLongArray(@NonNull String str, long[] jArr) {
            this.mValues.put(str, Data.convertPrimitiveLongArray(jArr));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        @NonNull
        public Builder putStringArray(@NonNull String str, String[] strArr) {
            this.mValues.put(str, strArr);
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    this.mValues.put(key, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.mValues.put(key, value);
                    } else if (cls == boolean[].class) {
                        this.mValues.put(key, Data.convertPrimitiveBooleanArray((boolean[]) value));
                    } else if (cls == int[].class) {
                        this.mValues.put(key, Data.convertPrimitiveIntArray((int[]) value));
                    } else if (cls == long[].class) {
                        this.mValues.put(key, Data.convertPrimitiveLongArray((long[]) value));
                    } else if (cls == float[].class) {
                        this.mValues.put(key, Data.convertPrimitiveFloatArray((float[]) value));
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                        }
                        this.mValues.put(key, Data.convertPrimitiveDoubleArray((double[]) value));
                    }
                }
            }
            return this;
        }
    }

    public Data() {
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x002f A[EXC_TOP_SPLITTER, PHI: r2
      0x002f: PHI (r2v7 java.io.ObjectInputStream) = (r2v6 java.io.ObjectInputStream), (r2v8 java.io.ObjectInputStream) binds: [B:31:0x004e, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @NonNull
    @TypeConverter
    public static Data fromByteArray(@NonNull byte[] bArr) throws Throwable {
        Throwable th2;
        ObjectInputStream objectInputStream;
        Throwable e10;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240KB when serialized");
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        try {
                            for (int i10 = objectInputStream.readInt(); i10 > 0; i10--) {
                                map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                            }
                        } catch (IOException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            if (objectInputStream != null) {
                            }
                            byteArrayInputStream.close();
                            return new Data(map);
                        } catch (ClassNotFoundException e12) {
                            e10 = e12;
                            e10.printStackTrace();
                            if (objectInputStream != null) {
                            }
                            byteArrayInputStream.close();
                            return new Data(map);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (0 != 0) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                            throw th2;
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            throw th2;
                        }
                    }
                } catch (IOException e15) {
                    e = e15;
                    Throwable th4 = e;
                    objectInputStream = null;
                    e10 = th4;
                    e10.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    Throwable th5 = e;
                    objectInputStream = null;
                    e10 = th5;
                    e10.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (Throwable th6) {
                    th2 = th6;
                    if (0 != 0) {
                        objectInputStream2.close();
                    }
                    byteArrayInputStream.close();
                    throw th2;
                }
                byteArrayInputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            objectInputStream.close();
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        return new Data(map);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @NonNull
    @TypeConverter
    public static byte[] toByteArray(@NonNull Data data) throws Throwable {
        boolean zHasNext;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r10 = 0;
        r10 = 0;
        r10 = 0;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        try {
                            objectOutputStream.writeInt(data.size());
                            Iterator<Map.Entry<String, Object>> it = data.mValues.entrySet().iterator();
                            while (true) {
                                zHasNext = it.hasNext();
                                if (!zHasNext) {
                                    break;
                                }
                                Map.Entry<String, Object> next = it.next();
                                objectOutputStream.writeUTF(next.getKey());
                                objectOutputStream.writeObject(next.getValue());
                            }
                            objectOutputStream.close();
                            r10 = zHasNext;
                        } catch (IOException e10) {
                            e = e10;
                            r10 = objectOutputStream;
                            e.printStackTrace();
                            if (r10 != 0) {
                                r10.close();
                                r10 = r10;
                            }
                            byteArrayOutputStream.close();
                            if (byteArrayOutputStream.size() <= 10240) {
                                return byteArrayOutputStream.toByteArray();
                            }
                            throw new IllegalStateException("Data cannot occupy more than 10240KB when serialized");
                        } catch (Throwable th2) {
                            th = th2;
                            r10 = objectOutputStream;
                            if (r10 != 0) {
                                try {
                                    r10.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException e12) {
                                e12.printStackTrace();
                                throw th;
                            }
                        }
                        byteArrayOutputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e14) {
                e = e14;
            }
        } catch (IOException e15) {
            e15.printStackTrace();
        }
        if (byteArrayOutputStream.size() <= 10240) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("Data cannot occupy more than 10240KB when serialized");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        return this.mValues.equals(((Data) obj).mValues);
    }

    public boolean getBoolean(@NonNull String str, boolean z10) {
        Object obj = this.mValues.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
    }

    @NonNull
    public boolean[] getBooleanArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (!(obj instanceof Boolean[])) {
            return null;
        }
        Boolean[] boolArr = (Boolean[]) obj;
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    public double getDouble(@NonNull String str, double d10) {
        Object obj = this.mValues.get(str);
        return obj instanceof Double ? ((Double) obj).doubleValue() : d10;
    }

    @Nullable
    public double[] getDoubleArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (!(obj instanceof Double[])) {
            return null;
        }
        Double[] dArr = (Double[]) obj;
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }

    public float getFloat(@NonNull String str, float f10) {
        Object obj = this.mValues.get(str);
        return obj instanceof Float ? ((Float) obj).floatValue() : f10;
    }

    @Nullable
    public float[] getFloatArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (!(obj instanceof Float[])) {
            return null;
        }
        Float[] fArr = (Float[]) obj;
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    public int getInt(@NonNull String str, int i10) {
        Object obj = this.mValues.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i10;
    }

    @NonNull
    public int[] getIntArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (!(obj instanceof Integer[])) {
            return null;
        }
        Integer[] numArr = (Integer[]) obj;
        int[] iArr = new int[numArr.length];
        for (int i10 = 0; i10 < numArr.length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return DesugarCollections.unmodifiableMap(this.mValues);
    }

    public long getLong(@NonNull String str, long j10) {
        Object obj = this.mValues.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j10;
    }

    @Nullable
    public long[] getLongArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (!(obj instanceof Long[])) {
            return null;
        }
        Long[] lArr = (Long[]) obj;
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    @Nullable
    public String getString(@NonNull String str, @Nullable String str2) {
        Object obj = this.mValues.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    @Nullable
    public String[] getStringArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    @VisibleForTesting
    public int size() {
        return this.mValues.size();
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }
}
