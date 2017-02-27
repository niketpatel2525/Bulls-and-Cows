package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0190e {
    static void m749a(LatLng latLng, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, latLng.getVersionCode());
        C0066b.m114a(parcel, 2, latLng.latitude);
        C0066b.m114a(parcel, 3, latLng.longitude);
        C0066b.m112C(parcel, k);
    }
}
