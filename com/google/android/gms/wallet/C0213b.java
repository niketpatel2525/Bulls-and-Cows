package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0213b implements Creator<Cart> {
    static void m778a(Cart cart, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, cart.getVersionCode());
        C0066b.m121a(parcel, 2, cart.tD, false);
        C0066b.m121a(parcel, 3, cart.tE, false);
        C0066b.m130b(parcel, 4, cart.tF, false);
        C0066b.m112C(parcel, k);
    }

    public Cart m779O(Parcel parcel) {
        String str = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = C0065a.m82c(parcel, i2, LineItem.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public Cart[] at(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m779O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return at(x0);
    }
}
