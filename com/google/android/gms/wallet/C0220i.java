package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.i */
public class C0220i implements Creator<NotifyTransactionStatusRequest> {
    static void m792a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, notifyTransactionStatusRequest.iM);
        C0066b.m121a(parcel, 2, notifyTransactionStatusRequest.tH, false);
        C0066b.m131c(parcel, 3, notifyTransactionStatusRequest.status);
        C0066b.m121a(parcel, 4, notifyTransactionStatusRequest.uj, false);
        C0066b.m112C(parcel, k);
    }

    public NotifyTransactionStatusRequest m793V(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0065a.m92j(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0065a.m94l(parcel, i3);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0065a.m94l(parcel, i3);
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public NotifyTransactionStatusRequest[] aA(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m793V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
