package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.g */
public class C0637g extends C0591f {

    /* renamed from: com.google.android.gms.internal.g.a */
    class C0149a {
        private String dt;
        private boolean du;
        final /* synthetic */ C0637g dv;

        public C0149a(C0637g c0637g, String str, boolean z) {
            this.dv = c0637g;
            this.dt = str;
            this.du = z;
        }

        public String getId() {
            return this.dt;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.du;
        }
    }

    private C0637g(Context context, C0153j c0153j, C0154k c0154k) {
        super(context, c0153j, c0154k);
    }

    public static C0637g m2122a(String str, Context context) {
        C0153j c0366a = new C0366a();
        C0591f.m1902a(str, context, c0366a);
        return new C0637g(context, c0366a, new C0466m(239));
    }

    protected void m2123b(Context context) {
        long j = 1;
        super.m1910b(context);
        try {
            C0149a f = m2124f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m1300a(28, j);
                String id = f.getId();
                if (id != null) {
                    m1301a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m1300a(28, 1);
        }
    }

    C0149a m2124f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.di.m667a(bArr, true);
            }
            return new C0149a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
