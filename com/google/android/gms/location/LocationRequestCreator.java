package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m705a(LocationRequest locationRequest, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, locationRequest.mPriority);
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0066b.m116a(parcel, 2, locationRequest.oJ);
        C0066b.m116a(parcel, 3, locationRequest.oK);
        C0066b.m124a(parcel, 4, locationRequest.oL);
        C0066b.m116a(parcel, 5, locationRequest.oC);
        C0066b.m131c(parcel, 6, locationRequest.oM);
        C0066b.m115a(parcel, 7, locationRequest.oN);
        C0066b.m112C(parcel, k);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0065a.m92j(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0065a.m87g(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j3 = C0065a.m87g(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0065a.m83c(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j4 = C0065a.m87g(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0065a.m86f(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    f = C0065a.m89i(parcel, i4);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0065a.m86f(parcel, i4);
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LocationRequest(i3, i, j2, j3, z, j4, i2, f);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
