package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.d */
public class C0215d implements Creator<FullWalletRequest> {
    static void m782a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, fullWalletRequest.getVersionCode());
        C0066b.m121a(parcel, 2, fullWalletRequest.tH, false);
        C0066b.m121a(parcel, 3, fullWalletRequest.tI, false);
        C0066b.m120a(parcel, 4, fullWalletRequest.tO, i, false);
        C0066b.m112C(parcel, k);
    }

    public FullWalletRequest m783Q(Parcel parcel) {
        Cart cart = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    cart = (Cart) C0065a.m77a(parcel, i2, Cart.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public FullWalletRequest[] av(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m783Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
