package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0192g {
    static void m751a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, polygonOptions.getVersionCode());
        C0066b.m130b(parcel, 2, polygonOptions.getPoints(), false);
        C0066b.m132c(parcel, 3, polygonOptions.cO(), false);
        C0066b.m115a(parcel, 4, polygonOptions.getStrokeWidth());
        C0066b.m131c(parcel, 5, polygonOptions.getStrokeColor());
        C0066b.m131c(parcel, 6, polygonOptions.getFillColor());
        C0066b.m115a(parcel, 7, polygonOptions.getZIndex());
        C0066b.m124a(parcel, 8, polygonOptions.isVisible());
        C0066b.m124a(parcel, 9, polygonOptions.isGeodesic());
        C0066b.m112C(parcel, k);
    }
}
