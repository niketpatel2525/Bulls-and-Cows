package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0066b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0186a {
    static void m745a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, cameraPosition.getVersionCode());
        C0066b.m120a(parcel, 2, cameraPosition.target, i, false);
        C0066b.m115a(parcel, 3, cameraPosition.zoom);
        C0066b.m115a(parcel, 4, cameraPosition.tilt);
        C0066b.m115a(parcel, 5, cameraPosition.bearing);
        C0066b.m112C(parcel, k);
    }
}
