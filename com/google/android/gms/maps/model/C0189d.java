package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0189d {
    static void m748a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, latLngBounds.getVersionCode());
        C0066b.m120a(parcel, 2, latLngBounds.southwest, i, false);
        C0066b.m120a(parcel, 3, latLngBounds.northeast, i, false);
        C0066b.m112C(parcel, k);
    }
}
