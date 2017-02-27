package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0191f {
    static void m750a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, markerOptions.getVersionCode());
        C0066b.m120a(parcel, 2, markerOptions.getPosition(), i, false);
        C0066b.m121a(parcel, 3, markerOptions.getTitle(), false);
        C0066b.m121a(parcel, 4, markerOptions.getSnippet(), false);
        C0066b.m118a(parcel, 5, markerOptions.cN(), false);
        C0066b.m115a(parcel, 6, markerOptions.getAnchorU());
        C0066b.m115a(parcel, 7, markerOptions.getAnchorV());
        C0066b.m124a(parcel, 8, markerOptions.isDraggable());
        C0066b.m124a(parcel, 9, markerOptions.isVisible());
        C0066b.m112C(parcel, k);
    }
}
