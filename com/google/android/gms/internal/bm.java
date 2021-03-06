package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0073e;
import com.google.android.gms.dynamic.C0569c;
import com.google.android.gms.internal.bn.C0402a;
import com.google.android.gms.internal.bo.C0404a;

public final class bm extends C0073e<bo> {
    private static final bm gl;

    /* renamed from: com.google.android.gms.internal.bm.a */
    private static final class C0104a extends Exception {
        public C0104a(String str) {
            super(str);
        }
    }

    static {
        gl = new bm();
    }

    private bm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bn m1186a(Activity activity) {
        try {
            if (!m1187b(activity)) {
                return gl.m1188c(activity);
            }
            cn.m295m("Using AdOverlay from the client jar.");
            return new bf(activity);
        } catch (C0104a e) {
            cn.m299q(e.getMessage());
            return null;
        }
    }

    private static boolean m1187b(Activity activity) throws C0104a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0104a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private bn m1188c(Activity activity) {
        try {
            return C0402a.m1191m(((bo) m145t(activity)).m219a(C0569c.m1773g(activity)));
        } catch (Throwable e) {
            cn.m293b("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            cn.m293b("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m1189d(IBinder iBinder) {
        return m1190l(iBinder);
    }

    protected bo m1190l(IBinder iBinder) {
        return C0404a.m1193n(iBinder);
    }
}
