package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0194i {
    static void m753a(Tile tile, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, tile.getVersionCode());
        C0066b.m131c(parcel, 2, tile.width);
        C0066b.m131c(parcel, 3, tile.height);
        C0066b.m125a(parcel, 4, tile.data, false);
        C0066b.m112C(parcel, k);
    }
}
