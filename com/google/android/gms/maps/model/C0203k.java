package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0203k {
    static void m768a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, visibleRegion.getVersionCode());
        C0066b.m120a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0066b.m120a(parcel, 3, visibleRegion.nearRight, i, false);
        C0066b.m120a(parcel, 4, visibleRegion.farLeft, i, false);
        C0066b.m120a(parcel, 5, visibleRegion.farRight, i, false);
        C0066b.m120a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0066b.m112C(parcel, k);
    }
}
