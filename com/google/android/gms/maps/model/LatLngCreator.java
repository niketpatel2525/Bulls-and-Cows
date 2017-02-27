package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m738a(LatLng latLng, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, latLng.getVersionCode());
        C0066b.m114a(parcel, 2, latLng.latitude);
        C0066b.m114a(parcel, 3, latLng.longitude);
        C0066b.m112C(parcel, k);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int j = C0065a.m92j(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    d2 = C0065a.m91j(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0065a.m91j(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LatLng(i, d2, d);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
