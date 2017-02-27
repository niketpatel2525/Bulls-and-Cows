package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.C0349f;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0576a extends C0349f<Room> {
    public C0576a(C0348d c0348d) {
        super(c0348d);
    }

    protected /* synthetic */ Object m1779a(int i, int i2) {
        return m1780b(i, i2);
    }

    protected Room m1780b(int i, int i2) {
        return new C0577c(this.jf, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
