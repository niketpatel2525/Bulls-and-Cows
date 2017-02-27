package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m741a(PolylineOptions polylineOptions, Parcel parcel, int i) {
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

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int j = C0065a.m92j(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0065a.m82c(parcel, i3, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f2 = C0065a.m89i(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0065a.m89i(parcel, i3);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    z2 = C0065a.m83c(parcel, i3);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    z = C0065a.m83c(parcel, i3);
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
