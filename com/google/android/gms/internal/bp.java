package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.bu.C0111a;

public final class bp {

    /* renamed from: com.google.android.gms.internal.bp.a */
    public interface C0105a {
        void m220a(ce ceVar);
    }

    public static cg m221a(Context context, C0111a c0111a, C0151h c0151h, cq cqVar, aw awVar, C0105a c0105a) {
        cg bqVar = new bq(context, c0111a, c0151h, cqVar, awVar, c0105a);
        bqVar.start();
        return bqVar;
    }
}
