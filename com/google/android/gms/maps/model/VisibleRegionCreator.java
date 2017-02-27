package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m744a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, visibleRegion.getVersionCode());
        C0066b.m120a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0066b.m120a(parcel, 3, visibleRegion.nearRight, i, false);
        C0066b.m120a(parcel, 4, visibleRegion.farLeft, i, false);
        C0066b.m120a(parcel, 5, visibleRegion.farRight, i, false);
        C0066b.m120a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0066b.m112C(parcel, k);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    latLng4 = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng3 = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    latLng2 = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    latLng = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    latLngBounds = (LatLngBounds) C0065a.m77a(parcel, i2, LatLngBounds.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
