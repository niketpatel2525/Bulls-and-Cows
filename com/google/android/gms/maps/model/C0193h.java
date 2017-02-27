package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0193h {
    static void m752a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, polylineOptions.getVersionCode());
        C0066b.m130b(parcel, 2, polylineOptions.getPoints(), false);
        C0066b.m115a(parcel, 3, polylineOptions.getWidth());
        C0066b.m131c(parcel, 4, polylineOptions.getColor());
        C0066b.m115a(parcel, 5, polylineOptions.getZIndex());
        C0066b.m124a(parcel, 6, polylineOptions.isVisible());
        C0066b.m124a(parcel, 7, polylineOptions.isGeodesic());
        C0066b.m112C(parcel, k);
    }
}
