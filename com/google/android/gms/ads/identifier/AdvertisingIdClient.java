package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0052a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0159p;
import com.google.android.gms.internal.C0159p.C0470a;
import com.google.android.gms.internal.dm;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String dX;
        private final boolean dY;

        Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.dX = advertisingId;
            this.dY = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.dX;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.dY;
        }
    }

    private static C0052a m15g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m32m(context);
                Object c0052a = new C0052a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0052a, 1)) {
                    return c0052a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        dm.m396x("Calling this from your main thread can lead to deadlock");
        ServiceConnection g = m15g(context);
        try {
            C0159p b = C0470a.m1521b(g.aG());
            Info info = new Info(b.getId(), b.m689a(true));
            context.unbindService(g);
            return info;
        } catch (Throwable e) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e);
            throw new IOException("Remote exception");
        } catch (InterruptedException e2) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            context.unbindService(g);
        }
    }
}
