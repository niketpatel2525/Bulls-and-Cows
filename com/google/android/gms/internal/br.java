package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.bs.C0578a;
import com.google.android.gms.internal.bs.C0579b;

public final class br {

    /* renamed from: com.google.android.gms.internal.br.a */
    public interface C0110a {
        void m222a(bw bwVar);
    }

    public static cg m223a(Context context, bu buVar, C0110a c0110a) {
        return buVar.eg.hS ? m224b(context, buVar, c0110a) : m225c(context, buVar, c0110a);
    }

    private static cg m224b(Context context, bu buVar, C0110a c0110a) {
        cn.m295m("Fetching ad response from local ad request service.");
        cg c0578a = new C0578a(context, buVar, c0110a);
        c0578a.start();
        return c0578a;
    }

    private static cg m225c(Context context, bu buVar, C0110a c0110a) {
        cn.m295m("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0579b(context, buVar, c0110a);
        }
        cn.m299q("Failed to connect to remote ad request service.");
        return null;
    }
}
