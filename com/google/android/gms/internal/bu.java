package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bu implements SafeParcelable {
    public static final bv CREATOR;
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final C0473x ed;
    public final co eg;
    public final Bundle gA;
    public final C0472v gB;
    public final PackageInfo gC;
    public final String gD;
    public final String gE;
    public final String gF;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.bu.a */
    public static final class C0111a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;
        public final C0473x ed;
        public final co eg;
        public final Bundle gA;
        public final C0472v gB;
        public final PackageInfo gC;
        public final String gE;
        public final String gF;

        public C0111a(Bundle bundle, C0472v c0472v, C0473x c0473x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, co coVar) {
            this.gA = bundle;
            this.gB = c0472v;
            this.ed = c0473x;
            this.adUnitId = str;
            this.applicationInfo = applicationInfo;
            this.gC = packageInfo;
            this.gE = str2;
            this.gF = str3;
            this.eg = coVar;
        }
    }

    static {
        CREATOR = new bv();
    }

    bu(int i, Bundle bundle, C0472v c0472v, C0473x c0473x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, co coVar) {
        this.versionCode = i;
        this.gA = bundle;
        this.gB = c0472v;
        this.ed = c0473x;
        this.adUnitId = str;
        this.applicationInfo = applicationInfo;
        this.gC = packageInfo;
        this.gD = str2;
        this.gE = str3;
        this.gF = str4;
        this.eg = coVar;
    }

    public bu(Bundle bundle, C0472v c0472v, C0473x c0473x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, co coVar) {
        this(1, bundle, c0472v, c0473x, str, applicationInfo, packageInfo, str2, str3, str4, coVar);
    }

    public bu(C0111a c0111a, String str) {
        this(c0111a.gA, c0111a.gB, c0111a.ed, c0111a.adUnitId, c0111a.applicationInfo, c0111a.gC, str, c0111a.gE, c0111a.gF, c0111a.eg);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        bv.m226a(this, out, flags);
    }
}
