package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dw.C0141b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class dt implements SafeParcelable, C0141b<String, Integer> {
    public static final du CREATOR;
    private final int iM;
    private final HashMap<String, Integer> lu;
    private final HashMap<Integer, String> lv;
    private final ArrayList<C0423a> lw;

    /* renamed from: com.google.android.gms.internal.dt.a */
    public static final class C0423a implements SafeParcelable {
        public static final dv CREATOR;
        final String lx;
        final int ly;
        final int versionCode;

        static {
            CREATOR = new dv();
        }

        C0423a(int i, String str, int i2) {
            this.versionCode = i;
            this.lx = str;
            this.ly = i2;
        }

        C0423a(String str, int i) {
            this.versionCode = 1;
            this.lx = str;
            this.ly = i;
        }

        public int describeContents() {
            dv dvVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            dv dvVar = CREATOR;
            dv.m410a(this, out, flags);
        }
    }

    static {
        CREATOR = new du();
    }

    public dt() {
        this.iM = 1;
        this.lu = new HashMap();
        this.lv = new HashMap();
        this.lw = null;
    }

    dt(int i, ArrayList<C0423a> arrayList) {
        this.iM = i;
        this.lu = new HashMap();
        this.lv = new HashMap();
        this.lw = null;
        m1273a((ArrayList) arrayList);
    }

    private void m1273a(ArrayList<C0423a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0423a c0423a = (C0423a) it.next();
            m1275c(c0423a.lx, c0423a.ly);
        }
    }

    public String m1274a(Integer num) {
        String str = (String) this.lv.get(num);
        return (str == null && this.lu.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    ArrayList<C0423a> bm() {
        ArrayList<C0423a> arrayList = new ArrayList();
        for (String str : this.lu.keySet()) {
            arrayList.add(new C0423a(str, ((Integer) this.lu.get(str)).intValue()));
        }
        return arrayList;
    }

    public int bn() {
        return 7;
    }

    public int bo() {
        return 0;
    }

    public dt m1275c(String str, int i) {
        this.lu.put(str, Integer.valueOf(i));
        this.lv.put(Integer.valueOf(i), str);
        return this;
    }

    public int describeContents() {
        du duVar = CREATOR;
        return 0;
    }

    public /* synthetic */ Object m1276f(Object obj) {
        return m1274a((Integer) obj);
    }

    int getVersionCode() {
        return this.iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        du duVar = CREATOR;
        du.m407a(this, out, flags);
    }
}
