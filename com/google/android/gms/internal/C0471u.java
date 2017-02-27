package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0073e;
import com.google.android.gms.dynamic.C0569c;
import com.google.android.gms.internal.ac.C0370a;
import com.google.android.gms.internal.ad.C0372a;

/* renamed from: com.google.android.gms.internal.u */
public final class C0471u extends C0073e<ad> {
    private static final C0471u er;

    static {
        er = new C0471u();
    }

    private C0471u() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ac m1522a(Context context, C0473x c0473x, String str, av avVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ac b = er.m1523b(context, c0473x, str, avVar);
            if (b != null) {
                return b;
            }
        }
        cn.m295m("Using AdManager from the client jar.");
        return new C0605r(context, c0473x, str, avVar, new co(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private ac m1523b(Context context, C0473x c0473x, String str, av avVar) {
        try {
            return C0370a.m1127f(((ad) m145t(context)).m173a(C0569c.m1773g(context), c0473x, str, avVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            cn.m293b("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            cn.m293b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ad m1524c(IBinder iBinder) {
        return C0372a.m1129g(iBinder);
    }

    protected /* synthetic */ Object m1525d(IBinder iBinder) {
        return m1524c(iBinder);
    }
}
