package cu.todus.android.location;

import ab.e;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.k;
import pe.m0;
import pe.n0;
import re.s;
import re.u;
import re.w;
import te.b0;
import te.h;
import te.j;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcu/todus/android/location/LocationDataSource;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/location/Location;", "location", "Lua/k0;", "updateCurrentLocation", "(Landroid/location/Location;)V", "Lte/h;", "getCurrentPosition", "()Lte/h;", "autoUpdate", "(Lab/e;)Ljava/lang/Object;", "currentLocation", "()Landroid/location/Location;", "Landroid/content/Context;", "Lte/b0;", "_currentLocation", "Lte/b0;", "Lte/p0;", "currentLocationFlow", "Lte/p0;", "getCurrentLocationFlow", "()Lte/p0;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Landroid/location/LocationManager;", "locationManager", "Landroid/location/LocationManager;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LocationDataSource {
    private final b0 _currentLocation;
    private final Context context;
    private final m0 coroutineScope;
    private final p0 currentLocationFlow;
    private final LocationManager locationManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.location.LocationDataSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.location.LocationDataSource$1", f = "LocationDataSource.kt", l = {WebmConstants.MkvEbmlElement.PIXEL_HEIGHT}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return LocationDataSource.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                LocationDataSource locationDataSource = LocationDataSource.this;
                this.label = 1;
                if (locationDataSource.autoUpdate(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/location/LocationDataSource$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/location/LocationDataSource;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<LocationDataSource> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.location.LocationDataSource$autoUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.location.LocationDataSource", f = "LocationDataSource.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, 175, 177}, m = "autoUpdate", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10101 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10101(e<? super C10101> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationDataSource.this.autoUpdate(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.location.LocationDataSource$getCurrentPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.location.LocationDataSource$getCurrentPosition$1", f = "LocationDataSource.kt", l = {157}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "Landroid/location/Location;", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10111 extends m implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.location.LocationDataSource$getCurrentPosition$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.todus.android.location.LocationDataSource$getCurrentPosition$1$3", f = "LocationDataSource.kt", l = {153}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends m implements Function2 {
            final /* synthetic */ u $$this$callbackFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(u uVar, e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final e<k0> create(Object obj, e<?> eVar) {
                return new AnonymousClass3(this.$$this$callbackFlow, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    u uVar = this.$$this$callbackFlow;
                    this.label = 1;
                    if (CoroutineUtilsKt.sendWithPrecautions(uVar, null, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                C10111.invokeSuspend$close(this.$$this$callbackFlow);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        public C10111(e<? super C10111> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(u uVar) {
            w.a.a(uVar.getChannel(), null, 1, null);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            C10111 c10111 = LocationDataSource.this.new C10111(eVar);
            c10111.L$0 = obj;
            return c10111;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final u uVar = (u) this.L$0;
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                if (ContextCompat.checkSelfPermission(LocationDataSource.this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(LocationDataSource.this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        LocationManager locationManager = LocationDataSource.this.locationManager;
                        final LocationDataSource locationDataSource = LocationDataSource.this;
                        locationManager.requestLocationUpdates("network", 1000L, 2.0f, new LocationListener() { // from class: cu.todus.android.location.LocationDataSource.getCurrentPosition.1.1
                            @Override // android.location.LocationListener
                            public void onLocationChanged(Location location) {
                                y.i(location, "location");
                                k.d(locationDataSource.coroutineScope, null, null, new LocationDataSource$getCurrentPosition$1$1$onLocationChanged$1(uVar, location, null), 3, null);
                            }

                            @Override // android.location.LocationListener
                            public void onProviderDisabled(String provider) {
                                y.i(provider, "provider");
                            }

                            @Override // android.location.LocationListener
                            public void onProviderEnabled(String provider) {
                                y.i(provider, "provider");
                            }

                            @Override // android.location.LocationListener
                            public void onStatusChanged(String provider, int status, Bundle extras) {
                            }
                        });
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    try {
                        LocationManager locationManager2 = LocationDataSource.this.locationManager;
                        final LocationDataSource locationDataSource2 = LocationDataSource.this;
                        locationManager2.requestLocationUpdates("gps", 500L, 2.0f, new LocationListener() { // from class: cu.todus.android.location.LocationDataSource.getCurrentPosition.1.2
                            @Override // android.location.LocationListener
                            public void onLocationChanged(Location location) {
                                y.i(location, "location");
                                k.d(locationDataSource2.coroutineScope, null, null, new LocationDataSource$getCurrentPosition$1$2$onLocationChanged$1(uVar, location, null), 3, null);
                            }

                            @Override // android.location.LocationListener
                            public void onProviderDisabled(String provider) {
                                y.i(provider, "provider");
                            }

                            @Override // android.location.LocationListener
                            public void onProviderEnabled(String provider) {
                                y.i(provider, "provider");
                            }

                            @Override // android.location.LocationListener
                            public void onStatusChanged(String provider, int status, Bundle extras) {
                            }
                        });
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                } else {
                    k.d(LocationDataSource.this.coroutineScope, null, null, new AnonymousClass3(uVar, null), 3, null);
                }
                lb.a aVar = new lb.a() { // from class: cu.todus.android.location.a
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                this.L$0 = l.a(uVar);
                this.label = 1;
                if (s.a(uVar, aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u uVar, e<? super k0> eVar) {
            return ((C10111) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public LocationDataSource(Context context) {
        y.i(context, "context");
        this.context = context;
        b0 b0VarA = r0.a(null);
        this._currentLocation = b0VarA;
        this.currentLocationFlow = j.b(b0VarA);
        m0 m0VarA = n0.a(d1.c());
        this.coroutineScope = m0VarA;
        Object systemService = context.getSystemService("location");
        y.g(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
        k.d(m0VarA, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        if (autoUpdate(r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object autoUpdate(ab.e<? super ua.k0> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cu.todus.android.location.LocationDataSource.C10101
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.location.LocationDataSource$autoUpdate$1 r0 = (cu.todus.android.location.LocationDataSource.C10101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.location.LocationDataSource$autoUpdate$1 r0 = new cu.todus.android.location.LocationDataSource$autoUpdate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.L$0
            android.location.Location r0 = (android.location.Location) r0
            ua.v.b(r7)
            goto L85
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            java.lang.Object r2 = r0.L$0
            android.location.Location r2 = (android.location.Location) r2
            ua.v.b(r7)
            goto L76
        L43:
            ua.v.b(r7)
            goto L57
        L47:
            ua.v.b(r7)
            te.h r7 = r6.getCurrentPosition()
            r0.label = r5
            java.lang.Object r7 = te.j.x(r7, r0)
            if (r7 != r1) goto L57
            goto L84
        L57:
            r2 = r7
            android.location.Location r2 = (android.location.Location) r2
            if (r2 == 0) goto L65
            r2.getLatitude()
            r2.getLongitude()
            r6.updateCurrentLocation(r2)
        L65:
            java.lang.Object r7 = cb.l.a(r2)
            r0.L$0 = r7
            r0.label = r4
            r4 = 4000(0xfa0, double:1.9763E-320)
            java.lang.Object r7 = pe.w0.b(r4, r0)
            if (r7 != r1) goto L76
            goto L84
        L76:
            java.lang.Object r7 = cb.l.a(r2)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r6.autoUpdate(r0)
            if (r7 != r1) goto L85
        L84:
            return r1
        L85:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.location.LocationDataSource.autoUpdate(ab.e):java.lang.Object");
    }

    private final h getCurrentPosition() {
        return j.e(new C10111(null));
    }

    private final void updateCurrentLocation(Location location) {
        this._currentLocation.setValue(location);
    }

    public final Location currentLocation() {
        return (Location) this._currentLocation.getValue();
    }

    public final p0 getCurrentLocationFlow() {
        return this.currentLocationFlow;
    }
}
