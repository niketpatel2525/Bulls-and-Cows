package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0054b {
    protected final C0348d jf;
    protected final int ji;
    private final int jj;

    public C0054b(C0348d c0348d, int i) {
        this.jf = (C0348d) dm.m392e(c0348d);
        boolean z = i >= 0 && i < c0348d.getCount();
        dm.m393k(z);
        this.ji = i;
        this.jj = c0348d.m1102q(this.ji);
    }

    protected void m40a(String str, CharArrayBuffer charArrayBuffer) {
        this.jf.m1094a(str, this.ji, this.jj, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0054b)) {
            return false;
        }
        C0054b c0054b = (C0054b) obj;
        return dl.equal(Integer.valueOf(c0054b.ji), Integer.valueOf(this.ji)) && dl.equal(Integer.valueOf(c0054b.jj), Integer.valueOf(this.jj)) && c0054b.jf == this.jf;
    }

    protected boolean getBoolean(String column) {
        return this.jf.m1098d(column, this.ji, this.jj);
    }

    protected byte[] getByteArray(String column) {
        return this.jf.m1099e(column, this.ji, this.jj);
    }

    protected int getInteger(String column) {
        return this.jf.m1095b(column, this.ji, this.jj);
    }

    protected long getLong(String column) {
        return this.jf.m1093a(column, this.ji, this.jj);
    }

    protected String getString(String column) {
        return this.jf.m1097c(column, this.ji, this.jj);
    }

    public int hashCode() {
        return dl.hashCode(Integer.valueOf(this.ji), Integer.valueOf(this.jj), this.jf);
    }

    public boolean isDataValid() {
        return !this.jf.isClosed();
    }

    protected Uri m41u(String str) {
        return this.jf.m1100f(str, this.ji, this.jj);
    }

    protected boolean m42v(String str) {
        return this.jf.m1101g(str, this.ji, this.jj);
    }
}
