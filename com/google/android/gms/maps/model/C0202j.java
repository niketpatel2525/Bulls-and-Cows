package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0202j {
    static void m767a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0066b.m118a(parcel, 2, tileOverlayOptions.cP(), false);
        C0066b.m124a(parcel, 3, tileOverlayOptions.isVisible());
        C0066b.m115a(parcel, 4, tileOverlayOptions.getZIndex());
        C0066b.m112C(parcel, k);
    }
}
