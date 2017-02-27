package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class dw {

    /* renamed from: com.google.android.gms.internal.dw.b */
    public interface C0141b<I, O> {
        int bn();

        int bo();

        I m413f(O o);
    }

    /* renamed from: com.google.android.gms.internal.dw.a */
    public static class C0424a<I, O> implements SafeParcelable {
        public static final dx CREATOR;
        private final int iM;
        protected final boolean lA;
        protected final int lB;
        protected final boolean lC;
        protected final String lD;
        protected final int lE;
        protected final Class<? extends dw> lF;
        protected final String lG;
        private dz lH;
        private C0141b<I, O> lI;
        protected final int lz;

        static {
            CREATOR = new dx();
        }

        C0424a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, dr drVar) {
            this.iM = i;
            this.lz = i2;
            this.lA = z;
            this.lB = i3;
            this.lC = z2;
            this.lD = str;
            this.lE = i4;
            if (str2 == null) {
                this.lF = null;
                this.lG = null;
            } else {
                this.lF = ec.class;
                this.lG = str2;
            }
            if (drVar == null) {
                this.lI = null;
            } else {
                this.lI = drVar.bl();
            }
        }

        protected C0424a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends dw> cls, C0141b<I, O> c0141b) {
            this.iM = 1;
            this.lz = i;
            this.lA = z;
            this.lB = i2;
            this.lC = z2;
            this.lD = str;
            this.lE = i3;
            this.lF = cls;
            if (cls == null) {
                this.lG = null;
            } else {
                this.lG = cls.getCanonicalName();
            }
            this.lI = c0141b;
        }

        public static C0424a m1277a(String str, int i, C0141b<?, ?> c0141b, boolean z) {
            return new C0424a(c0141b.bn(), z, c0141b.bo(), false, str, i, null, c0141b);
        }

        public static <T extends dw> C0424a<T, T> m1278a(String str, int i, Class<T> cls) {
            return new C0424a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends dw> C0424a<ArrayList<T>, ArrayList<T>> m1279b(String str, int i, Class<T> cls) {
            return new C0424a(11, true, 11, true, str, i, cls, null);
        }

        public static C0424a<Integer, Integer> m1281d(String str, int i) {
            return new C0424a(0, false, 0, false, str, i, null, null);
        }

        public static C0424a<Double, Double> m1282e(String str, int i) {
            return new C0424a(4, false, 4, false, str, i, null, null);
        }

        public static C0424a<Boolean, Boolean> m1283f(String str, int i) {
            return new C0424a(6, false, 6, false, str, i, null, null);
        }

        public static C0424a<String, String> m1284g(String str, int i) {
            return new C0424a(7, false, 7, false, str, i, null, null);
        }

        public static C0424a<ArrayList<String>, ArrayList<String>> m1285h(String str, int i) {
            return new C0424a(7, true, 7, true, str, i, null, null);
        }

        public void m1286a(dz dzVar) {
            this.lH = dzVar;
        }

        dr bA() {
            return this.lI == null ? null : dr.m1272a(this.lI);
        }

        public HashMap<String, C0424a<?, ?>> bB() {
            dm.m392e(this.lG);
            dm.m392e(this.lH);
            return this.lH.m1290H(this.lG);
        }

        public int bn() {
            return this.lz;
        }

        public int bo() {
            return this.lB;
        }

        public C0424a<I, O> bs() {
            return new C0424a(this.iM, this.lz, this.lA, this.lB, this.lC, this.lD, this.lE, this.lG, bA());
        }

        public boolean bt() {
            return this.lA;
        }

        public boolean bu() {
            return this.lC;
        }

        public String bv() {
            return this.lD;
        }

        public int bw() {
            return this.lE;
        }

        public Class<? extends dw> bx() {
            return this.lF;
        }

        String by() {
            return this.lG == null ? null : this.lG;
        }

        public boolean bz() {
            return this.lI != null;
        }

        public int describeContents() {
            dx dxVar = CREATOR;
            return 0;
        }

        public I m1287f(O o) {
            return this.lI.m413f(o);
        }

        public int getVersionCode() {
            return this.iM;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.iM).append('\n');
            stringBuilder.append("                 typeIn=").append(this.lz).append('\n');
            stringBuilder.append("            typeInArray=").append(this.lA).append('\n');
            stringBuilder.append("                typeOut=").append(this.lB).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.lC).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.lD).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.lE).append('\n');
            stringBuilder.append("       concreteTypeName=").append(by()).append('\n');
            if (bx() != null) {
                stringBuilder.append("     concreteType.class=").append(bx().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.lI == null ? "null" : this.lI.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            dx dxVar = CREATOR;
            dx.m423a(this, out, flags);
        }
    }

    private void m414a(StringBuilder stringBuilder, C0424a c0424a, Object obj) {
        if (c0424a.bn() == 11) {
            stringBuilder.append(((dw) c0424a.bx().cast(obj)).toString());
        } else if (c0424a.bn() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(ei.m449I((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m415a(StringBuilder stringBuilder, C0424a c0424a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m414a(stringBuilder, c0424a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected abstract Object m416D(String str);

    protected abstract boolean m417E(String str);

    protected boolean m418F(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean m419G(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected <O, I> I m420a(C0424a<I, O> c0424a, Object obj) {
        return c0424a.lI != null ? c0424a.m1287f(obj) : obj;
    }

    protected boolean m421a(C0424a c0424a) {
        return c0424a.bo() == 11 ? c0424a.bu() ? m419G(c0424a.bv()) : m418F(c0424a.bv()) : m417E(c0424a.bv());
    }

    protected Object m422b(C0424a c0424a) {
        boolean z = true;
        String bv = c0424a.bv();
        if (c0424a.bx() == null) {
            return m416D(c0424a.bv());
        }
        if (m416D(c0424a.bv()) != null) {
            z = false;
        }
        dm.m389a(z, "Concrete field shouldn't be value object: " + c0424a.bv());
        Map br = c0424a.bu() ? br() : bq();
        if (br != null) {
            return br.get(bv);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(bv.charAt(0)) + bv.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, C0424a<?, ?>> bp();

    public HashMap<String, Object> bq() {
        return null;
    }

    public HashMap<String, Object> br() {
        return null;
    }

    public String toString() {
        HashMap bp = bp();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : bp.keySet()) {
            C0424a c0424a = (C0424a) bp.get(str);
            if (m421a(c0424a)) {
                Object a = m420a(c0424a, m422b(c0424a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c0424a.bo()) {
                        case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                            stringBuilder.append("\"").append(ef.m445b((byte[]) a)).append("\"");
                            break;
                        case ConnectionResult.SERVICE_INVALID /*9*/:
                            stringBuilder.append("\"").append(ef.m446c((byte[]) a)).append("\"");
                            break;
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                            ej.m450a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c0424a.bt()) {
                                m414a(stringBuilder, c0424a, a);
                                break;
                            }
                            m415a(stringBuilder, c0424a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
