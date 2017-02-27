package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0054b;
import com.google.android.gms.common.data.C0348d;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0568b extends C0054b implements AppState {
    C0568b(C0348d c0348d, int i) {
        super(c0348d, i);
    }

    public AppState aE() {
        return new C0567a(this);
    }

    public boolean equals(Object obj) {
        return C0567a.m1770a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return aE();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !m42v("conflict_version");
    }

    public int hashCode() {
        return C0567a.m1769a(this);
    }

    public String toString() {
        return C0567a.m1771b(this);
    }
}
