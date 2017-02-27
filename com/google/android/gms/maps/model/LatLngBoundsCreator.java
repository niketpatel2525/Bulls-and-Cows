package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m737a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, latLngBounds.getVersionCode());
        C0066b.m120a(parcel, 2, latLngBounds.southwest, i, false);
        C0066b.m120a(parcel, 3, latLngBounds.northeast, i, false);
        C0066b.m112C(parcel, k);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < j) {
            int f;
            LatLng latLng3;
            int i2 = C0065a.m90i(parcel);
            LatLng latLng4;
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    f = C0065a.m86f(parcel, i2);
                    latLng3 = latLng4;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    f = i;
                    latLng4 = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng3 = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    latLng = latLng2;
                    f = i;
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    latLng3 = latLng;
                    latLng = latLng2;
                    f = i;
                    break;
            }
            i = f;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == j) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
