package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class ce {
    public final List<String> eW;
    public final List<String> eX;
    public final int errorCode;
    public final cq fU;
    public final long fa;
    public final ao fm;
    public final ax fn;
    public final String fo;
    public final ar fp;
    public final C0472v gB;
    public final String gE;
    public final long gH;
    public final boolean gI;
    public final long gJ;
    public final List<String> gK;
    public final ap hA;
    public final int orientation;

    public ce(C0472v c0472v, cq cqVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, ao aoVar, ax axVar, String str2, ap apVar, ar arVar, long j2, long j3) {
        this.gB = c0472v;
        this.fU = cqVar;
        this.eW = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.eX = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.gK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.fa = j;
        this.gE = str;
        this.gI = z;
        this.fm = aoVar;
        this.fn = axVar;
        this.fo = str2;
        this.hA = apVar;
        this.fp = arVar;
        this.gJ = j2;
        this.gH = j3;
    }
}
