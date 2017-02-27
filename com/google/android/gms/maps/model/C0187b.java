package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0187b {
    static void m746a(CircleOptions circleOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, circleOptions.getVersionCode());
        C0066b.m120a(parcel, 2, circleOptions.getCenter(), i, false);
        C0066b.m114a(parcel, 3, circleOptions.getRadius());
        C0066b.m115a(parcel, 4, circleOptions.getStrokeWidth());
        C0066b.m131c(parcel, 5, circleOptions.getStrokeColor());
        C0066b.m131c(parcel, 6, circleOptions.getFillColor());
        C0066b.m115a(parcel, 7, circleOptions.getZIndex());
        C0066b.m124a(parcel, 8, circleOptions.isVisible());
        C0066b.m112C(parcel, k);
    }
}
