package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.internal.C0170c;
import com.google.android.gms.maps.internal.C0184q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void initialize(Context context) throws GooglePlayServicesNotAvailableException {
        dm.m392e(context);
        C0170c u = C0184q.m729u(context);
        try {
            CameraUpdateFactory.m707a(u.cG());
            BitmapDescriptorFactory.m732a(u.cH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
