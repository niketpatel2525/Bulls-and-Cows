package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.de.C0134b;
import com.google.android.gms.internal.de.C0582d;
import com.google.android.gms.internal.fd.C0448a;
import com.google.android.gms.internal.fe.C0450a;
import com.google.android.gms.panorama.PanoramaClient.C0204a;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

public class ff extends de<fe> {

    /* renamed from: com.google.android.gms.internal.ff.a */
    final class C0451a extends C0134b<C0204a> {
        public final ConnectionResult qV;
        public final Intent qW;
        final /* synthetic */ ff qX;
        public final int type;

        public C0451a(ff ffVar, C0204a c0204a, ConnectionResult connectionResult, int i, Intent intent) {
            this.qX = ffVar;
            super(ffVar, c0204a);
            this.qV = connectionResult;
            this.type = i;
            this.qW = intent;
        }

        protected void m1477a(C0204a c0204a) {
            if (c0204a != null) {
                c0204a.m769a(this.qV, this.type, this.qW);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.c */
    final class C0452c extends C0134b<OnPanoramaInfoLoadedListener> {
        private final ConnectionResult qV;
        private final Intent qW;
        final /* synthetic */ ff qX;

        public C0452c(ff ffVar, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, ConnectionResult connectionResult, Intent intent) {
            this.qX = ffVar;
            super(ffVar, onPanoramaInfoLoadedListener);
            this.qV = connectionResult;
            this.qW = intent;
        }

        protected void m1479a(OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            if (onPanoramaInfoLoadedListener != null) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(this.qV, this.qW);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.b */
    final class C0592b extends C0448a {
        final /* synthetic */ ff qX;
        private final C0204a qY;
        private final OnPanoramaInfoLoadedListener qZ;
        private final Uri ra;

        public C0592b(ff ffVar, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
            this.qX = ffVar;
            this.qY = null;
            this.qZ = onPanoramaInfoLoadedListener;
            this.ra = uri;
        }

        public void m1912a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.ra != null) {
                this.qX.getContext().revokeUriPermission(this.ra, 1);
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (this.qY != null) {
                this.qX.m1243a(new C0451a(this.qX, this.qY, connectionResult, i2, intent));
            } else {
                this.qX.m1243a(new C0452c(this.qX, this.qZ, connectionResult, intent));
            }
        }
    }

    public ff(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    protected void m1913a(dj djVar, C0582d c0582d) throws RemoteException {
        djVar.m372a(c0582d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m1914a(C0592b c0592b, Uri uri, Bundle bundle, boolean z) {
        bc();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((fe) bd()).m586a(c0592b, uri, bundle, z);
        } catch (RemoteException e) {
            c0592b.m1912a(8, null, 0, null);
        }
    }

    public void m1915a(OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri, boolean z) {
        m1914a(new C0592b(this, onPanoramaInfoLoadedListener, z ? uri : null), uri, null, z);
    }

    protected String ag() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public fe am(IBinder iBinder) {
        return C0450a.al(iBinder);
    }

    public /* synthetic */ IInterface m1916p(IBinder iBinder) {
        return am(iBinder);
    }
}
