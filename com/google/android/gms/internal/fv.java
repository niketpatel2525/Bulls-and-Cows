package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import android.support.v4.widget.ViewDragHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.dw.C0424a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.sxnyodot.uefqvmio207964.C0300h;
import com.sxnyodot.uefqvmio207964.C0303k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class fv extends dw implements SafeParcelable, Person {
    public static final fw CREATOR;
    private static final HashMap<String, C0424a<?, ?>> rH;
    private int dI;
    private String hN;
    private final int iM;
    private String ml;
    private final Set<Integer> rI;
    private String sJ;
    private C0595a sK;
    private String sL;
    private String sM;
    private int sN;
    private C0598b sO;
    private String sP;
    private C0599c sQ;
    private boolean sR;
    private String sS;
    private C0600d sT;
    private String sU;
    private int sV;
    private List<C0601f> sW;
    private List<C0602g> sX;
    private int sY;
    private int sZ;
    private String sm;
    private String ta;
    private List<C0603h> tb;
    private boolean tc;

    /* renamed from: com.google.android.gms.internal.fv.e */
    public static class C0148e {
        public static int aa(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.a */
    public static final class C0595a extends dw implements SafeParcelable, AgeRange {
        public static final fx CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private final Set<Integer> rI;
        private int td;
        private int te;

        static {
            CREATOR = new fx();
            rH = new HashMap();
            rH.put("max", C0424a.m1281d("max", 2));
            rH.put("min", C0424a.m1281d("min", 3));
        }

        public C0595a() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        C0595a(Set<Integer> set, int i, int i2, int i3) {
            this.rI = set;
            this.iM = i;
            this.td = i2;
            this.te = i3;
        }

        protected Object m1944D(String str) {
            return null;
        }

        protected boolean m1945E(String str) {
            return false;
        }

        protected boolean m1946a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1947b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return Integer.valueOf(this.td);
                case DetectedActivity.STILL /*3*/:
                    return Integer.valueOf(this.te);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        public C0595a dL() {
            return this;
        }

        public int describeContents() {
            fx fxVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0595a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0595a c0595a = (C0595a) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1946a(c0424a)) {
                    if (!c0595a.m1946a(c0424a)) {
                        return false;
                    }
                    if (!m1947b(c0424a).equals(c0595a.m1947b(c0424a))) {
                        return false;
                    }
                } else if (c0595a.m1946a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dL();
        }

        public int getMax() {
            return this.td;
        }

        public int getMin() {
            return this.te;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasMax() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.rI.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1946a(c0424a)) {
                    hashCode = m1947b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            fx fxVar = CREATOR;
            fx.m623a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.b */
    public static final class C0598b extends dw implements SafeParcelable, Cover {
        public static final fy CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private final Set<Integer> rI;
        private C0596a tf;
        private C0597b tg;
        private int th;

        /* renamed from: com.google.android.gms.internal.fv.b.a */
        public static final class C0596a extends dw implements SafeParcelable, CoverInfo {
            public static final fz CREATOR;
            private static final HashMap<String, C0424a<?, ?>> rH;
            private final int iM;
            private final Set<Integer> rI;
            private int ti;
            private int tj;

            static {
                CREATOR = new fz();
                rH = new HashMap();
                rH.put("leftImageOffset", C0424a.m1281d("leftImageOffset", 2));
                rH.put("topImageOffset", C0424a.m1281d("topImageOffset", 3));
            }

            public C0596a() {
                this.iM = 1;
                this.rI = new HashSet();
            }

            C0596a(Set<Integer> set, int i, int i2, int i3) {
                this.rI = set;
                this.iM = i;
                this.ti = i2;
                this.tj = i3;
            }

            protected Object m1948D(String str) {
                return null;
            }

            protected boolean m1949E(String str) {
                return false;
            }

            protected boolean m1950a(C0424a c0424a) {
                return this.rI.contains(Integer.valueOf(c0424a.bw()));
            }

            protected Object m1951b(C0424a c0424a) {
                switch (c0424a.bw()) {
                    case DetectedActivity.ON_FOOT /*2*/:
                        return Integer.valueOf(this.ti);
                    case DetectedActivity.STILL /*3*/:
                        return Integer.valueOf(this.tj);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
                }
            }

            public HashMap<String, C0424a<?, ?>> bp() {
                return rH;
            }

            public C0596a dP() {
                return this;
            }

            public int describeContents() {
                fz fzVar = CREATOR;
                return 0;
            }

            Set<Integer> di() {
                return this.rI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0596a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0596a c0596a = (C0596a) obj;
                for (C0424a c0424a : rH.values()) {
                    if (m1950a(c0424a)) {
                        if (!c0596a.m1950a(c0424a)) {
                            return false;
                        }
                        if (!m1951b(c0424a).equals(c0596a.m1951b(c0424a))) {
                            return false;
                        }
                    } else if (c0596a.m1950a(c0424a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return dP();
            }

            public int getLeftImageOffset() {
                return this.ti;
            }

            public int getTopImageOffset() {
                return this.tj;
            }

            int getVersionCode() {
                return this.iM;
            }

            public boolean hasLeftImageOffset() {
                return this.rI.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.rI.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0424a c0424a : rH.values()) {
                    int hashCode;
                    if (m1950a(c0424a)) {
                        hashCode = m1951b(c0424a).hashCode() + (i + c0424a.bw());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                fz fzVar = CREATOR;
                fz.m627a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.fv.b.b */
        public static final class C0597b extends dw implements SafeParcelable, CoverPhoto {
            public static final ga CREATOR;
            private static final HashMap<String, C0424a<?, ?>> rH;
            private int dP;
            private int dQ;
            private String hN;
            private final int iM;
            private final Set<Integer> rI;

            static {
                CREATOR = new ga();
                rH = new HashMap();
                rH.put(IM.HEIGHT, C0424a.m1281d(IM.HEIGHT, 2));
                rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0424a.m1284g(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                rH.put(IM.WIDTH, C0424a.m1281d(IM.WIDTH, 4));
            }

            public C0597b() {
                this.iM = 1;
                this.rI = new HashSet();
            }

            C0597b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.rI = set;
                this.iM = i;
                this.dQ = i2;
                this.hN = str;
                this.dP = i3;
            }

            protected Object m1952D(String str) {
                return null;
            }

            protected boolean m1953E(String str) {
                return false;
            }

            protected boolean m1954a(C0424a c0424a) {
                return this.rI.contains(Integer.valueOf(c0424a.bw()));
            }

            protected Object m1955b(C0424a c0424a) {
                switch (c0424a.bw()) {
                    case DetectedActivity.ON_FOOT /*2*/:
                        return Integer.valueOf(this.dQ);
                    case DetectedActivity.STILL /*3*/:
                        return this.hN;
                    case DetectedActivity.UNKNOWN /*4*/:
                        return Integer.valueOf(this.dP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
                }
            }

            public HashMap<String, C0424a<?, ?>> bp() {
                return rH;
            }

            public C0597b dQ() {
                return this;
            }

            public int describeContents() {
                ga gaVar = CREATOR;
                return 0;
            }

            Set<Integer> di() {
                return this.rI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0597b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0597b c0597b = (C0597b) obj;
                for (C0424a c0424a : rH.values()) {
                    if (m1954a(c0424a)) {
                        if (!c0597b.m1954a(c0424a)) {
                            return false;
                        }
                        if (!m1955b(c0424a).equals(c0597b.m1955b(c0424a))) {
                            return false;
                        }
                    } else if (c0597b.m1954a(c0424a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return dQ();
            }

            public int getHeight() {
                return this.dQ;
            }

            public String getUrl() {
                return this.hN;
            }

            int getVersionCode() {
                return this.iM;
            }

            public int getWidth() {
                return this.dP;
            }

            public boolean hasHeight() {
                return this.rI.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.rI.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.rI.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0424a c0424a : rH.values()) {
                    int hashCode;
                    if (m1954a(c0424a)) {
                        hashCode = m1955b(c0424a).hashCode() + (i + c0424a.bw());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                ga gaVar = CREATOR;
                ga.m629a(this, out, flags);
            }
        }

        static {
            CREATOR = new fy();
            rH = new HashMap();
            rH.put("coverInfo", C0424a.m1278a("coverInfo", 2, C0596a.class));
            rH.put("coverPhoto", C0424a.m1278a("coverPhoto", 3, C0597b.class));
            rH.put("layout", C0424a.m1277a("layout", 4, new dt().m1275c("banner", 0), false));
        }

        public C0598b() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        C0598b(Set<Integer> set, int i, C0596a c0596a, C0597b c0597b, int i2) {
            this.rI = set;
            this.iM = i;
            this.tf = c0596a;
            this.tg = c0597b;
            this.th = i2;
        }

        protected Object m1956D(String str) {
            return null;
        }

        protected boolean m1957E(String str) {
            return false;
        }

        protected boolean m1958a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1959b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.tf;
                case DetectedActivity.STILL /*3*/:
                    return this.tg;
                case DetectedActivity.UNKNOWN /*4*/:
                    return Integer.valueOf(this.th);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        C0596a dM() {
            return this.tf;
        }

        C0597b dN() {
            return this.tg;
        }

        public C0598b dO() {
            return this;
        }

        public int describeContents() {
            fy fyVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0598b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0598b c0598b = (C0598b) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1958a(c0424a)) {
                    if (!c0598b.m1958a(c0424a)) {
                        return false;
                    }
                    if (!m1959b(c0424a).equals(c0598b.m1959b(c0424a))) {
                        return false;
                    }
                } else if (c0598b.m1958a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dO();
        }

        public CoverInfo getCoverInfo() {
            return this.tf;
        }

        public CoverPhoto getCoverPhoto() {
            return this.tg;
        }

        public int getLayout() {
            return this.th;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasCoverInfo() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.rI.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.rI.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1958a(c0424a)) {
                    hashCode = m1959b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            fy fyVar = CREATOR;
            fy.m625a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.c */
    public static final class C0599c extends dw implements SafeParcelable, Image {
        public static final gb CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private String hN;
        private final int iM;
        private final Set<Integer> rI;

        static {
            CREATOR = new gb();
            rH = new HashMap();
            rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0424a.m1284g(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C0599c() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        public C0599c(String str) {
            this.rI = new HashSet();
            this.iM = 1;
            this.hN = str;
            this.rI.add(Integer.valueOf(2));
        }

        C0599c(Set<Integer> set, int i, String str) {
            this.rI = set;
            this.iM = i;
            this.hN = str;
        }

        protected Object m1960D(String str) {
            return null;
        }

        protected boolean m1961E(String str) {
            return false;
        }

        protected boolean m1962a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1963b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.hN;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        public C0599c dR() {
            return this;
        }

        public int describeContents() {
            gb gbVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0599c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0599c c0599c = (C0599c) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1962a(c0424a)) {
                    if (!c0599c.m1962a(c0424a)) {
                        return false;
                    }
                    if (!m1963b(c0424a).equals(c0599c.m1963b(c0424a))) {
                        return false;
                    }
                } else if (c0599c.m1962a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dR();
        }

        public String getUrl() {
            return this.hN;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasUrl() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1962a(c0424a)) {
                    hashCode = m1963b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            gb gbVar = CREATOR;
            gb.m631a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.d */
    public static final class C0600d extends dw implements SafeParcelable, Name {
        public static final gc CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private final Set<Integer> rI;
        private String sh;
        private String sk;
        private String tk;
        private String tl;
        private String tm;
        private String tn;

        static {
            CREATOR = new gc();
            rH = new HashMap();
            rH.put("familyName", C0424a.m1284g("familyName", 2));
            rH.put("formatted", C0424a.m1284g("formatted", 3));
            rH.put("givenName", C0424a.m1284g("givenName", 4));
            rH.put("honorificPrefix", C0424a.m1284g("honorificPrefix", 5));
            rH.put("honorificSuffix", C0424a.m1284g("honorificSuffix", 6));
            rH.put("middleName", C0424a.m1284g("middleName", 7));
        }

        public C0600d() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        C0600d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.rI = set;
            this.iM = i;
            this.sh = str;
            this.tk = str2;
            this.sk = str3;
            this.tl = str4;
            this.tm = str5;
            this.tn = str6;
        }

        protected Object m1964D(String str) {
            return null;
        }

        protected boolean m1965E(String str) {
            return false;
        }

        protected boolean m1966a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1967b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.sh;
                case DetectedActivity.STILL /*3*/:
                    return this.tk;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.sk;
                case DetectedActivity.TILTING /*5*/:
                    return this.tl;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    return this.tm;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    return this.tn;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        public C0600d dS() {
            return this;
        }

        public int describeContents() {
            gc gcVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0600d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0600d c0600d = (C0600d) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1966a(c0424a)) {
                    if (!c0600d.m1966a(c0424a)) {
                        return false;
                    }
                    if (!m1967b(c0424a).equals(c0600d.m1967b(c0424a))) {
                        return false;
                    }
                } else if (c0600d.m1966a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dS();
        }

        public String getFamilyName() {
            return this.sh;
        }

        public String getFormatted() {
            return this.tk;
        }

        public String getGivenName() {
            return this.sk;
        }

        public String getHonorificPrefix() {
            return this.tl;
        }

        public String getHonorificSuffix() {
            return this.tm;
        }

        public String getMiddleName() {
            return this.tn;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasFamilyName() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.rI.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.rI.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.rI.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.rI.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.rI.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1966a(c0424a)) {
                    hashCode = m1967b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            gc gcVar = CREATOR;
            gc.m633a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.f */
    public static final class C0601f extends dw implements SafeParcelable, Organizations {
        public static final gd CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private int jV;
        private String mName;
        private String mo;
        private String qB;
        private final Set<Integer> rI;
        private String sg;
        private String sx;
        private String to;
        private String tp;
        private boolean tq;

        static {
            CREATOR = new gd();
            rH = new HashMap();
            rH.put("department", C0424a.m1284g("department", 2));
            rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0424a.m1284g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            rH.put("endDate", C0424a.m1284g("endDate", 4));
            rH.put("location", C0424a.m1284g("location", 5));
            rH.put("name", C0424a.m1284g("name", 6));
            rH.put("primary", C0424a.m1283f("primary", 7));
            rH.put("startDate", C0424a.m1284g("startDate", 8));
            rH.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0424a.m1284g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            rH.put(C0303k.MEDIA_FILE_TYPE, C0424a.m1277a(C0303k.MEDIA_FILE_TYPE, 10, new dt().m1275c("work", 0).m1275c("school", 1), false));
        }

        public C0601f() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        C0601f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.rI = set;
            this.iM = i;
            this.to = str;
            this.mo = str2;
            this.sg = str3;
            this.tp = str4;
            this.mName = str5;
            this.tq = z;
            this.sx = str6;
            this.qB = str7;
            this.jV = i2;
        }

        protected Object m1968D(String str) {
            return null;
        }

        protected boolean m1969E(String str) {
            return false;
        }

        protected boolean m1970a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1971b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.to;
                case DetectedActivity.STILL /*3*/:
                    return this.mo;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.sg;
                case DetectedActivity.TILTING /*5*/:
                    return this.tp;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    return this.mName;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    return Boolean.valueOf(this.tq);
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    return this.sx;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    return this.qB;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    return Integer.valueOf(this.jV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        public C0601f dT() {
            return this;
        }

        public int describeContents() {
            gd gdVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0601f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0601f c0601f = (C0601f) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1970a(c0424a)) {
                    if (!c0601f.m1970a(c0424a)) {
                        return false;
                    }
                    if (!m1971b(c0424a).equals(c0601f.m1971b(c0424a))) {
                        return false;
                    }
                } else if (c0601f.m1970a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dT();
        }

        public String getDepartment() {
            return this.to;
        }

        public String getDescription() {
            return this.mo;
        }

        public String getEndDate() {
            return this.sg;
        }

        public String getLocation() {
            return this.tp;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.sx;
        }

        public String getTitle() {
            return this.qB;
        }

        public int getType() {
            return this.jV;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasDepartment() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.rI.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.rI.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.rI.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.rI.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.rI.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.rI.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.rI.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.rI.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1970a(c0424a)) {
                    hashCode = m1971b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.tq;
        }

        public void writeToParcel(Parcel out, int flags) {
            gd gdVar = CREATOR;
            gd.m635a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.g */
    public static final class C0602g extends dw implements SafeParcelable, PlacesLived {
        public static final ge CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private String mValue;
        private final Set<Integer> rI;
        private boolean tq;

        static {
            CREATOR = new ge();
            rH = new HashMap();
            rH.put("primary", C0424a.m1283f("primary", 2));
            rH.put("value", C0424a.m1284g("value", 3));
        }

        public C0602g() {
            this.iM = 1;
            this.rI = new HashSet();
        }

        C0602g(Set<Integer> set, int i, boolean z, String str) {
            this.rI = set;
            this.iM = i;
            this.tq = z;
            this.mValue = str;
        }

        protected Object m1972D(String str) {
            return null;
        }

        protected boolean m1973E(String str) {
            return false;
        }

        protected boolean m1974a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1975b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return Boolean.valueOf(this.tq);
                case DetectedActivity.STILL /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        public C0602g dU() {
            return this;
        }

        public int describeContents() {
            ge geVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0602g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0602g c0602g = (C0602g) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1974a(c0424a)) {
                    if (!c0602g.m1974a(c0424a)) {
                        return false;
                    }
                    if (!m1975b(c0424a).equals(c0602g.m1975b(c0424a))) {
                        return false;
                    }
                } else if (c0602g.m1974a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dU();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasPrimary() {
            return this.rI.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.rI.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1974a(c0424a)) {
                    hashCode = m1975b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.tq;
        }

        public void writeToParcel(Parcel out, int flags) {
            ge geVar = CREATOR;
            ge.m637a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fv.h */
    public static final class C0603h extends dw implements SafeParcelable, Urls {
        public static final gf CREATOR;
        private static final HashMap<String, C0424a<?, ?>> rH;
        private final int iM;
        private int jV;
        private String mValue;
        private final Set<Integer> rI;
        private String tr;
        private final int ts;

        static {
            CREATOR = new gf();
            rH = new HashMap();
            rH.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0424a.m1284g(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            rH.put(C0303k.MEDIA_FILE_TYPE, C0424a.m1277a(C0303k.MEDIA_FILE_TYPE, 6, new dt().m1275c("home", 0).m1275c("work", 1).m1275c("blog", 2).m1275c("profile", 3).m1275c("other", 4).m1275c("otherProfile", 5).m1275c("contributor", 6).m1275c("website", 7), false));
            rH.put("value", C0424a.m1284g("value", 4));
        }

        public C0603h() {
            this.ts = 4;
            this.iM = 2;
            this.rI = new HashSet();
        }

        C0603h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.ts = 4;
            this.rI = set;
            this.iM = i;
            this.tr = str;
            this.jV = i2;
            this.mValue = str2;
        }

        protected Object m1976D(String str) {
            return null;
        }

        protected boolean m1977E(String str) {
            return false;
        }

        protected boolean m1978a(C0424a c0424a) {
            return this.rI.contains(Integer.valueOf(c0424a.bw()));
        }

        protected Object m1979b(C0424a c0424a) {
            switch (c0424a.bw()) {
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.mValue;
                case DetectedActivity.TILTING /*5*/:
                    return this.tr;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    return Integer.valueOf(this.jV);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
            }
        }

        public HashMap<String, C0424a<?, ?>> bp() {
            return rH;
        }

        @Deprecated
        public int dV() {
            return 4;
        }

        public C0603h dW() {
            return this;
        }

        public int describeContents() {
            gf gfVar = CREATOR;
            return 0;
        }

        Set<Integer> di() {
            return this.rI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0603h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0603h c0603h = (C0603h) obj;
            for (C0424a c0424a : rH.values()) {
                if (m1978a(c0424a)) {
                    if (!c0603h.m1978a(c0424a)) {
                        return false;
                    }
                    if (!m1979b(c0424a).equals(c0603h.m1979b(c0424a))) {
                        return false;
                    }
                } else if (c0603h.m1978a(c0424a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return dW();
        }

        public String getLabel() {
            return this.tr;
        }

        public int getType() {
            return this.jV;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.iM;
        }

        public boolean hasLabel() {
            return this.rI.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.rI.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.rI.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0424a c0424a : rH.values()) {
                int hashCode;
                if (m1978a(c0424a)) {
                    hashCode = m1979b(c0424a).hashCode() + (i + c0424a.bw());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            gf gfVar = CREATOR;
            gf.m639a(this, out, flags);
        }
    }

    static {
        CREATOR = new fw();
        rH = new HashMap();
        rH.put("aboutMe", C0424a.m1284g("aboutMe", 2));
        rH.put("ageRange", C0424a.m1278a("ageRange", 3, C0595a.class));
        rH.put("birthday", C0424a.m1284g("birthday", 4));
        rH.put("braggingRights", C0424a.m1284g("braggingRights", 5));
        rH.put("circledByCount", C0424a.m1281d("circledByCount", 6));
        rH.put("cover", C0424a.m1278a("cover", 7, C0598b.class));
        rH.put("currentLocation", C0424a.m1284g("currentLocation", 8));
        rH.put("displayName", C0424a.m1284g("displayName", 9));
        rH.put("gender", C0424a.m1277a("gender", 12, new dt().m1275c("male", 0).m1275c("female", 1).m1275c("other", 2), false));
        rH.put(C0303k.ID, C0424a.m1284g(C0303k.ID, 14));
        rH.put("image", C0424a.m1278a("image", 15, C0599c.class));
        rH.put("isPlusUser", C0424a.m1283f("isPlusUser", 16));
        rH.put(C0300h.LANGUAGE, C0424a.m1284g(C0300h.LANGUAGE, 18));
        rH.put("name", C0424a.m1278a("name", 19, C0600d.class));
        rH.put("nickname", C0424a.m1284g("nickname", 20));
        rH.put("objectType", C0424a.m1277a("objectType", 21, new dt().m1275c("person", 0).m1275c("page", 1), false));
        rH.put("organizations", C0424a.m1279b("organizations", 22, C0601f.class));
        rH.put("placesLived", C0424a.m1279b("placesLived", 23, C0602g.class));
        rH.put("plusOneCount", C0424a.m1281d("plusOneCount", 24));
        rH.put("relationshipStatus", C0424a.m1277a("relationshipStatus", 25, new dt().m1275c("single", 0).m1275c("in_a_relationship", 1).m1275c("engaged", 2).m1275c("married", 3).m1275c("its_complicated", 4).m1275c("open_relationship", 5).m1275c("widowed", 6).m1275c("in_domestic_partnership", 7).m1275c("in_civil_union", 8), false));
        rH.put("tagline", C0424a.m1284g("tagline", 26));
        rH.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0424a.m1284g(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        rH.put("urls", C0424a.m1279b("urls", 28, C0603h.class));
        rH.put("verified", C0424a.m1283f("verified", 29));
    }

    public fv() {
        this.iM = 2;
        this.rI = new HashSet();
    }

    public fv(String str, String str2, C0599c c0599c, int i, String str3) {
        this.iM = 2;
        this.rI = new HashSet();
        this.ml = str;
        this.rI.add(Integer.valueOf(9));
        this.sm = str2;
        this.rI.add(Integer.valueOf(14));
        this.sQ = c0599c;
        this.rI.add(Integer.valueOf(15));
        this.sV = i;
        this.rI.add(Integer.valueOf(21));
        this.hN = str3;
        this.rI.add(Integer.valueOf(27));
    }

    fv(Set<Integer> set, int i, String str, C0595a c0595a, String str2, String str3, int i2, C0598b c0598b, String str4, String str5, int i3, String str6, C0599c c0599c, boolean z, String str7, C0600d c0600d, String str8, int i4, List<C0601f> list, List<C0602g> list2, int i5, int i6, String str9, String str10, List<C0603h> list3, boolean z2) {
        this.rI = set;
        this.iM = i;
        this.sJ = str;
        this.sK = c0595a;
        this.sL = str2;
        this.sM = str3;
        this.sN = i2;
        this.sO = c0598b;
        this.sP = str4;
        this.ml = str5;
        this.dI = i3;
        this.sm = str6;
        this.sQ = c0599c;
        this.sR = z;
        this.sS = str7;
        this.sT = c0600d;
        this.sU = str8;
        this.sV = i4;
        this.sW = list;
        this.sX = list2;
        this.sY = i5;
        this.sZ = i6;
        this.ta = str9;
        this.hN = str10;
        this.tb = list3;
        this.tc = z2;
    }

    public static fv m1980e(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        fv D = CREATOR.m622D(obtain);
        obtain.recycle();
        return D;
    }

    protected Object m1981D(String str) {
        return null;
    }

    protected boolean m1982E(String str) {
        return false;
    }

    protected boolean m1983a(C0424a c0424a) {
        return this.rI.contains(Integer.valueOf(c0424a.bw()));
    }

    protected Object m1984b(C0424a c0424a) {
        switch (c0424a.bw()) {
            case DetectedActivity.ON_FOOT /*2*/:
                return this.sJ;
            case DetectedActivity.STILL /*3*/:
                return this.sK;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.sL;
            case DetectedActivity.TILTING /*5*/:
                return this.sM;
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                return Integer.valueOf(this.sN);
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                return this.sO;
            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                return this.sP;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return this.ml;
            case ConnectionResult.DATE_INVALID /*12*/:
                return Integer.valueOf(this.dI);
            case 14:
                return this.sm;
            case ViewDragHelper.EDGE_ALL /*15*/:
                return this.sQ;
            case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                return Boolean.valueOf(this.sR);
            case 18:
                return this.sS;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.sT;
            case 20:
                return this.sU;
            case 21:
                return Integer.valueOf(this.sV);
            case 22:
                return this.sW;
            case 23:
                return this.sX;
            case 24:
                return Integer.valueOf(this.sY);
            case 25:
                return Integer.valueOf(this.sZ);
            case 26:
                return this.ta;
            case 27:
                return this.hN;
            case 28:
                return this.tb;
            case 29:
                return Boolean.valueOf(this.tc);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0424a.bw());
        }
    }

    public HashMap<String, C0424a<?, ?>> bp() {
        return rH;
    }

    C0595a dD() {
        return this.sK;
    }

    C0598b dE() {
        return this.sO;
    }

    C0599c dF() {
        return this.sQ;
    }

    C0600d dG() {
        return this.sT;
    }

    List<C0601f> dH() {
        return this.sW;
    }

    List<C0602g> dI() {
        return this.sX;
    }

    List<C0603h> dJ() {
        return this.tb;
    }

    public fv dK() {
        return this;
    }

    public int describeContents() {
        fw fwVar = CREATOR;
        return 0;
    }

    Set<Integer> di() {
        return this.rI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fv)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        fv fvVar = (fv) obj;
        for (C0424a c0424a : rH.values()) {
            if (m1983a(c0424a)) {
                if (!fvVar.m1983a(c0424a)) {
                    return false;
                }
                if (!m1984b(c0424a).equals(fvVar.m1984b(c0424a))) {
                    return false;
                }
            } else if (fvVar.m1983a(c0424a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return dK();
    }

    public String getAboutMe() {
        return this.sJ;
    }

    public AgeRange getAgeRange() {
        return this.sK;
    }

    public String getBirthday() {
        return this.sL;
    }

    public String getBraggingRights() {
        return this.sM;
    }

    public int getCircledByCount() {
        return this.sN;
    }

    public Cover getCover() {
        return this.sO;
    }

    public String getCurrentLocation() {
        return this.sP;
    }

    public String getDisplayName() {
        return this.ml;
    }

    public int getGender() {
        return this.dI;
    }

    public String getId() {
        return this.sm;
    }

    public Image getImage() {
        return this.sQ;
    }

    public String getLanguage() {
        return this.sS;
    }

    public Name getName() {
        return this.sT;
    }

    public String getNickname() {
        return this.sU;
    }

    public int getObjectType() {
        return this.sV;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.sW;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.sX;
    }

    public int getPlusOneCount() {
        return this.sY;
    }

    public int getRelationshipStatus() {
        return this.sZ;
    }

    public String getTagline() {
        return this.ta;
    }

    public String getUrl() {
        return this.hN;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.tb;
    }

    int getVersionCode() {
        return this.iM;
    }

    public boolean hasAboutMe() {
        return this.rI.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.rI.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.rI.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.rI.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.rI.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.rI.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.rI.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.rI.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.rI.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.rI.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.rI.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.rI.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.rI.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.rI.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.rI.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.rI.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.rI.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.rI.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.rI.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.rI.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.rI.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.rI.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.rI.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.rI.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0424a c0424a : rH.values()) {
            int hashCode;
            if (m1983a(c0424a)) {
                hashCode = m1984b(c0424a).hashCode() + (i + c0424a.bw());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.sR;
    }

    public boolean isVerified() {
        return this.tc;
    }

    public void writeToParcel(Parcel out, int flags) {
        fw fwVar = CREATOR;
        fw.m621a(this, out, flags);
    }
}
