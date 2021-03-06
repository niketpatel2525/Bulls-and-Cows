package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m703a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m130b(parcel, 1, activityRecognitionResult.ov, false);
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, activityRecognitionResult.getVersionCode());
        C0066b.m116a(parcel, 2, activityRecognitionResult.ow);
        C0066b.m116a(parcel, 3, activityRecognitionResult.ox);
        C0066b.m112C(parcel, k);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int j2 = C0065a.m92j(parcel);
        int i = 0;
        List list = null;
        long j3 = 0;
        while (parcel.dataPosition() < j2) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    list = C0065a.m82c(parcel, i2, DetectedActivity.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j3 = C0065a.m87g(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0065a.m87g(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j2) {
            return new ActivityRecognitionResult(i, list, j3, j);
        }
        throw new C0064a("Overread allowed size end=" + j2, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
