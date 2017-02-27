package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0070b;
import com.google.android.gms.dynamic.C0569c;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0169b.C0498a;
import com.google.android.gms.maps.internal.C0171d.C0502a;
import com.google.android.gms.maps.internal.C0172e.C0504a;
import com.google.android.gms.maps.internal.C0173f.C0506a;
import com.google.android.gms.maps.internal.C0174g;
import com.google.android.gms.maps.internal.C0175h.C0510a;
import com.google.android.gms.maps.internal.C0176i.C0512a;
import com.google.android.gms.maps.internal.C0177j.C0514a;
import com.google.android.gms.maps.internal.C0178k.C0516a;
import com.google.android.gms.maps.internal.C0179l.C0518a;
import com.google.android.gms.maps.internal.C0180m.C0520a;
import com.google.android.gms.maps.internal.C0181n.C0522a;
import com.google.android.gms.maps.internal.C0182o.C0524a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0488a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0197c;
import com.google.android.gms.maps.model.internal.C0198d;
import com.google.android.gms.maps.model.internal.C0200f;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate pf;
    private UiSettings pg;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C0506a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnInfoWindowClickListener pt;

        AnonymousClass10(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.pi = googleMap;
            this.pt = onInfoWindowClickListener;
        }

        public void m2020e(C0198d c0198d) {
            this.pt.onInfoWindowClick(new Marker(c0198d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C0502a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ InfoWindowAdapter pu;

        AnonymousClass11(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.pi = googleMap;
            this.pu = infoWindowAdapter;
        }

        public C0070b m2021f(C0198d c0198d) {
            return C0569c.m1773g(this.pu.getInfoWindow(new Marker(c0198d)));
        }

        public C0070b m2022g(C0198d c0198d) {
            return C0569c.m1773g(this.pu.getInfoContents(new Marker(c0198d)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C0522a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMyLocationChangeListener pv;

        AnonymousClass12(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.pi = googleMap;
            this.pv = onMyLocationChangeListener;
        }

        public void m2023d(C0070b c0070b) {
            this.pv.onMyLocationChange((Location) C0569c.m1772b(c0070b));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C06081 extends C0488a {
        final /* synthetic */ LocationSource ph;
        final /* synthetic */ GoogleMap pi;

        /* renamed from: com.google.android.gms.maps.GoogleMap.1.1 */
        class C04761 implements OnLocationChangedListener {
            final /* synthetic */ C0174g pj;
            final /* synthetic */ C06081 pk;

            C04761(C06081 c06081, C0174g c0174g) {
                this.pk = c06081;
                this.pj = c0174g;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.pj.m719g(C0569c.m1773g(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C06081(GoogleMap googleMap, LocationSource locationSource) {
            this.pi = googleMap;
            this.ph = locationSource;
        }

        public void activate(C0174g listener) {
            this.ph.activate(new C04761(this, listener));
        }

        public void deactivate() {
            this.ph.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C06092 extends C0520a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMyLocationButtonClickListener pl;

        C06092(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.pi = googleMap;
            this.pl = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.pl.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C06103 extends C0512a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapLoadedCallback pm;

        C06103(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.pi = googleMap;
            this.pm = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.pm.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C06114 extends C0524a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ SnapshotReadyCallback pn;

        C06114(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.pi = googleMap;
            this.pn = snapshotReadyCallback;
        }

        public void m2024c(C0070b c0070b) throws RemoteException {
            this.pn.onSnapshotReady((Bitmap) C0569c.m1772b(c0070b));
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.pn.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C06125 extends C0504a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnCameraChangeListener po;

        C06125(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.pi = googleMap;
            this.po = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.po.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C06136 extends C0510a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapClickListener pp;

        C06136(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.pi = googleMap;
            this.pp = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.pp.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C06147 extends C0514a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapLongClickListener pq;

        C06147(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.pi = googleMap;
            this.pq = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.pq.onMapLongClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C06158 extends C0516a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMarkerClickListener pr;

        C06158(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.pi = googleMap;
            this.pr = onMarkerClickListener;
        }

        public boolean m2025a(C0198d c0198d) {
            return this.pr.onMarkerClick(new Marker(c0198d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C06169 extends C0518a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMarkerDragListener ps;

        C06169(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.pi = googleMap;
            this.ps = onMarkerDragListener;
        }

        public void m2026b(C0198d c0198d) {
            this.ps.onMarkerDragStart(new Marker(c0198d));
        }

        public void m2027c(C0198d c0198d) {
            this.ps.onMarkerDragEnd(new Marker(c0198d));
        }

        public void m2028d(C0198d c0198d) {
            this.ps.onMarkerDrag(new Marker(c0198d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C0617a extends C0498a {
        private final CancelableCallback pw;

        C0617a(CancelableCallback cancelableCallback) {
            this.pw = cancelableCallback;
        }

        public void onCancel() {
            this.pw.onCancel();
        }

        public void onFinish() {
            this.pw.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.pf = (IGoogleMapDelegate) dm.m392e(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.pf.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0197c addGroundOverlay = this.pf.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0198d addMarker = this.pf.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.pf.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.pf.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0200f addTileOverlay = this.pf.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.pf.animateCamera(update.cs());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.pf.animateCameraWithDurationAndCallback(update.cs(), durationMs, callback == null ? null : new C0617a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.pf.animateCameraWithCallback(update.cs(), callback == null ? null : new C0617a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.pf.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate cu() {
        return this.pf;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.pf.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.pf.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.pf.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.pf.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.pf.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.pf.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.pg == null) {
                this.pg = new UiSettings(this.pf.getUiSettings());
            }
            return this.pg;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.pf.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.pf.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.pf.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.pf.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.pf.moveCamera(update.cs());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.pf.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.pf.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.pf.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setInfoWindowAdapter(new AnonymousClass11(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.pf.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setLocationSource(new C06081(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.pf.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.pf.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnCameraChangeListener(new C06125(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnInfoWindowClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapClickListener(new C06136(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.pf.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapLoadedCallback(new C06103(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapLongClickListener(new C06147(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMarkerClickListener(new C06158(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMarkerDragListener(new C06169(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMyLocationButtonClickListener(new C06092(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMyLocationChangeListener(new AnonymousClass12(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.pf.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.pf.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.pf.snapshot(new C06114(this, callback), (C0569c) (bitmap != null ? C0569c.m1773g(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.pf.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
