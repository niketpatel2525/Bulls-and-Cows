package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.a */
public class C0167a {
    static void m709a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, googleMapOptions.getVersionCode());
        C0066b.m113a(parcel, 2, googleMapOptions.cv());
        C0066b.m113a(parcel, 3, googleMapOptions.cw());
        C0066b.m131c(parcel, 4, googleMapOptions.getMapType());
        C0066b.m120a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0066b.m113a(parcel, 6, googleMapOptions.cx());
        C0066b.m113a(parcel, 7, googleMapOptions.cy());
        C0066b.m113a(parcel, 8, googleMapOptions.cz());
        C0066b.m113a(parcel, 9, googleMapOptions.cA());
        C0066b.m113a(parcel, 10, googleMapOptions.cB());
        C0066b.m113a(parcel, 11, googleMapOptions.cC());
        C0066b.m112C(parcel, k);
    }
}
