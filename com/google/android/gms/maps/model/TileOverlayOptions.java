package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0185r;
import com.google.android.gms.maps.model.internal.C0201g;
import com.google.android.gms.maps.model.internal.C0201g.C0541a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR;
    private final int iM;
    private C0201g qP;
    private TileProvider qQ;
    private float qk;
    private boolean ql;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C05251 implements TileProvider {
        private final C0201g qR;
        final /* synthetic */ TileOverlayOptions qS;

        C05251(TileOverlayOptions tileOverlayOptions) {
            this.qS = tileOverlayOptions;
            this.qR = this.qS.qP;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.qR.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C06182 extends C0541a {
        final /* synthetic */ TileOverlayOptions qS;
        final /* synthetic */ TileProvider qT;

        C06182(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.qS = tileOverlayOptions;
            this.qT = tileProvider;
        }

        public Tile getTile(int x, int y, int zoom) {
            return this.qT.getTile(x, y, zoom);
        }
    }

    static {
        CREATOR = new TileOverlayOptionsCreator();
    }

    public TileOverlayOptions() {
        this.ql = true;
        this.iM = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex) {
        this.ql = true;
        this.iM = versionCode;
        this.qP = C0541a.aj(delegate);
        this.qQ = this.qP == null ? null : new C05251(this);
        this.ql = visible;
        this.qk = zIndex;
    }

    IBinder cP() {
        return this.qP.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public TileProvider getTileProvider() {
        return this.qQ;
    }

    int getVersionCode() {
        return this.iM;
    }

    public float getZIndex() {
        return this.qk;
    }

    public boolean isVisible() {
        return this.ql;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.qQ = tileProvider;
        this.qP = this.qQ == null ? null : new C06182(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.ql = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0185r.cK()) {
            C0202j.m767a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m743a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.qk = zIndex;
        return this;
    }
}
