package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.sxnyodot.uefqvmio207964.c */
class C0558c implements C0292b<String> {
    static final String AD_TYPE_ABCC = "ABCC";
    static final String AD_TYPE_ABCM = "ABCM";
    static final String AD_TYPE_ABU = "ABU";
    static final String AD_TYPE_BACC = "BACC";
    static final String AD_TYPE_BACM = "BACM";
    static final String AD_TYPE_BAU = "BAU";
    static final String AD_TYPE_VBCC = "VBCC";
    static final String AD_TYPE_VBCM = "VBCM";
    static final String AD_TYPE_VBU = "VBU";
    protected static final String BANNER_TYPE_360 = "360";
    protected static final String BANNER_TYPE_ABSTRACT = "AB";
    protected static final String BANNER_TYPE_ABSTRACT_LARGE = "ABL";
    protected static final String BANNER_TYPE_ABSTRACT_SMALL = "ABS";
    protected static final String BANNER_TYPE_ABSTRACT_STANDARD = "SB";
    protected static final String BANNER_TYPE_ABSTRACT_VIDEO = "VB";
    protected static final String BANNER_TYPE_IMAGE = "image";
    protected static final String BANNER_TYPE_TEXT = "text";
    protected static final int EVENT_ABL_CLICK = 29;
    protected static final int EVENT_ABL_CLOSE = 72;
    protected static final int EVENT_ABL_IMPRESSION = 37;
    protected static final int EVENT_ABS_CLICK = 26;
    protected static final int EVENT_ABS_CLOSE = 66;
    protected static final int EVENT_ABS_IMPRESSION = 35;
    protected static final int EVENT_BANNER_CLICK = 13;
    protected static final int EVENT_BANNER_IMPRESSION = 14;
    protected static final int EVENT_ERROR = 89;
    protected static final int EVENT_VB_CLICK = 56;
    protected static final int EVENT_VB_CLOSE = 57;
    protected static final int EVENT_VB_IMPRESSION = 36;
    private static boolean f559G = false;
    private static BannerAdListener f560H = null;
    static final int REFRESH_AD = 45;
    private String[] f561A;
    private String[] f562B;
    private boolean f563C;
    private long f564D;
    private int f565E;
    private final String f566F;
    private final int f567I;
    private Activity f568a;
    private String f569b;
    private String f570c;
    private String f571d;
    private String f572e;
    private HashMap<String, String> f573f;
    private final String f574g;
    private int f575h;
    private int f576i;
    private int f577j;
    private JSONObject f578k;
    private String f579l;
    private boolean f580m;
    private int f581n;
    private int f582o;
    private String f583p;
    private String f584q;
    private String f585r;
    private int f586s;
    private String f587t;
    private String f588u;
    private String f589v;
    private String f590w;
    private String f591x;
    private String f592y;
    private String f593z;

    /* renamed from: com.sxnyodot.uefqvmio207964.c.1 */
    class C02931 implements Runnable {
        final /* synthetic */ String f370a;
        final /* synthetic */ C0558c f371b;

        C02931(C0558c c0558c, String str) {
            this.f371b = c0558c;
            this.f370a = str;
        }

        public void run() {
            try {
                this.f371b.f578k = new JSONObject(this.f370a);
                if (!this.f371b.m1710a(this.f371b.f578k)) {
                    return;
                }
                if (this.f371b.f568a.isFinishing()) {
                    Log.w(C0300h.TAG, "Activity is in finishing state so ad is discarded");
                } else {
                    this.f371b.m1686G();
                }
            } catch (Throwable e) {
                Log.w(C0300h.TAG, e);
            } catch (IOException e2) {
                Log.i(C0300h.TAG, e2.getMessage());
            } catch (Throwable e3) {
                Log.w(C0300h.TAG, e3);
            }
        }
    }

    public C0558c(Activity activity, String str, int i, boolean z, BannerAdListener bannerAdListener) throws InvalidClassException {
        this.f574g = "imp_url";
        this.f575h = REFRESH_AD;
        this.f576i = REFRESH_AD;
        this.f577j = REFRESH_AD;
        this.f564D = 500;
        this.f565E = 0;
        if (activity instanceof Activity) {
            this.f568a = activity;
            this.f566F = str;
            f559G = z;
            f560H = bannerAdListener;
            this.f567I = i;
            return;
        }
        throw new InvalidClassException("Banner 360 ads require Running activity reference.");
    }

    public void m1706a() {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("banner_type", this.f566F));
        arrayList.add(new BasicNameValuePair("placement_id", "" + this.f567I));
        arrayList.add(new BasicNameValuePair("supports", "" + Util.m985s(this.f568a)));
        if (f559G) {
            arrayList.add(new BasicNameValuePair("sdk_test", "1"));
        }
        try {
            new Thread(new C0304m(this.f568a, this, arrayList, C0300h.URL_IN_APP_AD_API, 0, true), "banner360").start();
        } catch (Throwable e) {
            Log.e(C0300h.TAG, C0303k.ERROR, e);
        }
    }

    public void m1708a(String str) {
        Log.i(C0300h.TAG, "360 Json: " + str);
        if (str != null && str.length() != 0) {
            this.f568a.runOnUiThread(new C02931(this, str));
        }
    }

    private void m1686G() {
        try {
            View relativeLayout = new RelativeLayout(this.f568a);
            int c = C0558c.m1695c(this.f568a);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(EVENT_BANNER_IMPRESSION, -1);
            layoutParams.addRule(12);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, c);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(EVENT_BANNER_IMPRESSION, -1);
            relativeLayout.setId(70700);
            AbstractAdView.setJsonObject(this.f578k);
            relativeLayout.addView(new AbstractAdView(this.f568a, this), layoutParams2);
            this.f568a.addContentView(relativeLayout, layoutParams);
        } catch (Throwable e) {
            Log.e(C0300h.TAG, "Error occurred while adding banner", e);
        }
    }

    protected synchronized boolean m1710a(JSONObject jSONObject) throws JSONException, IOException, Exception {
        int i = REFRESH_AD;
        boolean z = false;
        synchronized (this) {
            Util.m929a("Parsing 360 json: " + jSONObject.toString());
            String str = C0300h.INVALID;
            this.f580m = jSONObject.isNull(IM.EVENT_ERROR) ? false : jSONObject.getBoolean(IM.EVENT_ERROR);
            int i2 = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
            String string = jSONObject.isNull(C0300h.TYPE_MESSAGE) ? str : jSONObject.getString(C0300h.TYPE_MESSAGE);
            if (i2 == 200 && string.equalsIgnoreCase("Success")) {
                this.f583p = jSONObject.isNull("adtype") ? str : jSONObject.getString("adtype");
                this.f569b = jSONObject.getString("banner_type");
                this.f575h = jSONObject.isNull("refreshtime") ? REFRESH_AD : jSONObject.getInt("refreshtime");
                this.f576i = jSONObject.isNull("crt") ? REFRESH_AD : jSONObject.getInt("crt");
                if (!jSONObject.isNull("clkt")) {
                    i = jSONObject.getInt("clkt");
                }
                this.f577j = i;
                this.f563C = jSONObject.isNull("is_sdk_redirect") ? false : jSONObject.getBoolean("is_sdk_redirect");
                this.f564D = jSONObject.isNull("cld") ? 500 : jSONObject.getLong("cld");
                this.f565E = jSONObject.isNull("cldc") ? 0 : jSONObject.getInt("cldc");
                String string2 = jSONObject.isNull("data") ? "nodata" : jSONObject.getString("data");
                if (string2.equals("nodata")) {
                    throw new IOException("No data is not found in JSON.");
                }
                int i3;
                int i4;
                JSONObject jSONObject2 = new JSONObject(string2);
                this.f572e = jSONObject2.isNull(PlusShare.KEY_CALL_TO_ACTION_URL) ? str : jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (!jSONObject2.isNull(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                    str = jSONObject2.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                }
                this.f589v = str;
                this.f587t = jSONObject2.isNull("adimage") ? "" : jSONObject2.getString("adimage");
                this.f584q = jSONObject2.isNull("creativeid") ? "" : jSONObject2.getString("creativeid");
                this.f585r = jSONObject2.isNull("campaignid") ? "" : jSONObject2.getString("campaignid");
                this.f592y = jSONObject2.isNull("sms") ? "" : jSONObject2.getString("sms");
                this.f593z = jSONObject2.isNull("number") ? "" : jSONObject2.getString("number");
                this.f591x = jSONObject2.isNull("banner_bg") ? "#000000" : jSONObject2.getString("banner_bg");
                this.f590w = jSONObject2.isNull("text_color") ? "#FFFFFF" : jSONObject2.getString("text_color");
                if (this.f566F.equals(BANNER_TYPE_ABSTRACT_LARGE) || this.f566F.equals(BANNER_TYPE_ABSTRACT_SMALL)) {
                    this.f581n = m1687H();
                } else {
                    this.f581n = jSONObject2.isNull(IM.WIDTH) ? 320 : jSONObject2.getInt(IM.WIDTH);
                }
                if (jSONObject2.isNull(IM.HEIGHT)) {
                    i3 = 50;
                } else {
                    i3 = jSONObject2.getInt(IM.HEIGHT);
                }
                this.f582o = i3;
                if (this.f569b.endsWith(BANNER_TYPE_TEXT)) {
                    if (this.f590w.equals("")) {
                        this.f590w = "#FFFFFF";
                        this.f591x = "#000000";
                        Log.w(C0300h.TAG, "Text color missing");
                    }
                    if (this.f591x.equals("")) {
                        this.f590w = "#FFFFFF";
                        this.f591x = "#000000";
                        Log.w(C0300h.TAG, "Banner bg missing");
                    }
                }
                this.f588u = jSONObject2.isNull(BANNER_TYPE_TEXT) ? "" : jSONObject2.getString(BANNER_TYPE_TEXT);
                if (this.f583p.equals(AD_TYPE_BAU) || this.f583p.equals(AD_TYPE_BACM) || this.f583p.equals(AD_TYPE_BACC)) {
                    this.f571d = jSONObject2.isNull("api_url") ? "" : jSONObject2.getString("api_url");
                } else {
                    this.f571d = jSONObject2.isNull("track_url") ? "" : jSONObject2.getString("track_url");
                }
                if (this.f571d.length() == 0 || f559G) {
                    Log.d(C0300h.TAG, "API url empty or in test mode");
                } else {
                    this.f573f = new HashMap();
                    if (this.f569b.equals(BANNER_TYPE_ABSTRACT_SMALL)) {
                        this.f573f.put("imp_url26", m1688a(this.f571d, "26"));
                        this.f573f.put("imp_url35", m1688a(this.f571d, "35"));
                        this.f573f.put("imp_url66", m1688a(this.f571d, "66"));
                    } else if (this.f569b.equals(BANNER_TYPE_ABSTRACT_LARGE)) {
                        this.f573f.put("imp_url29", m1688a(this.f571d, "29"));
                        this.f573f.put("imp_url37", m1688a(this.f571d, "37"));
                        this.f573f.put("imp_url72", m1688a(this.f571d, "72"));
                    } else if (this.f569b.equals(BANNER_TYPE_ABSTRACT_VIDEO)) {
                        this.f573f.put("imp_url56", m1688a(this.f571d, "56"));
                        this.f573f.put("imp_url36", m1688a(this.f571d, "36"));
                        this.f573f.put("imp_url57", m1688a(this.f571d, "57"));
                    } else {
                        this.f573f.put("imp_url13", m1688a(this.f571d, "13"));
                        this.f573f.put("imp_url14", m1688a(this.f571d, "14"));
                    }
                    this.f573f.put("imp_url89", m1688a(this.f571d, IM.MRAID_EVENT_ERROR));
                    Util.m929a("Urls: " + this.f573f);
                }
                this.f561A = m1692a("imp_beacon", jSONObject2);
                this.f562B = m1692a("click_beacon", jSONObject2);
                this.f570c = jSONObject2.isNull("tag") ? "" : jSONObject2.getString("tag");
                if (!jSONObject2.isNull("istag")) {
                    i4 = jSONObject2.getInt("istag");
                }
                this.f586s = i4;
                z = true;
            } else {
                AbstractAdView.m801a(i2, string);
            }
        }
        return z;
    }

    public String m1711b() {
        return this.f569b;
    }

    public String m1714c() {
        return this.f570c;
    }

    public int m1715d() {
        return this.f586s;
    }

    public String m1716e() {
        return this.f571d;
    }

    public String m1717f() {
        return this.f572e;
    }

    public int m1718g() {
        return this.f575h;
    }

    public int m1719h() {
        return this.f576i;
    }

    public int m1720i() {
        return this.f577j;
    }

    public String m1721j() {
        return this.f579l;
    }

    public boolean m1722k() {
        return this.f580m;
    }

    public int m1723l() {
        return this.f581n;
    }

    public int m1724m() {
        return this.f582o;
    }

    public String m1725n() {
        return this.f583p;
    }

    public String m1726o() {
        return this.f584q;
    }

    public String m1727p() {
        return this.f585r;
    }

    public String m1728q() {
        return this.f587t;
    }

    public String m1729r() {
        return this.f588u;
    }

    public String m1730s() {
        return this.f589v;
    }

    public String m1731t() {
        return this.f590w;
    }

    public String m1732u() {
        return this.f591x;
    }

    public String m1733v() {
        return this.f592y;
    }

    public String m1734w() {
        return this.f593z;
    }

    private String m1688a(String str, String str2) {
        if (str.contains("%event%")) {
            return str.replace("%event%", str2);
        }
        return str;
    }

    public String m1705a(int i) {
        if (this.f573f != null) {
            return (String) this.f573f.get("imp_url" + i);
        }
        return null;
    }

    public void m1712b(int i) {
        if (this.f573f != null) {
            this.f573f.remove("imp_url" + i);
        }
    }

    static boolean m1691a(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            Editor edit = context.getSharedPreferences("banner360_ad_call", 0).edit();
            long currentTimeMillis = 10000 + System.currentTimeMillis();
            edit.putLong("START_TIME", currentTimeMillis);
            z = edit.commit();
            Log.i(C0300h.TAG, "Next Banner 360 ad call time: " + new Date(currentTimeMillis).toString());
            return z;
        } catch (Exception e) {
            return z;
        }
    }

    static long m1693b(Context context) {
        if (context == null) {
            return 0;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("banner360_ad_call", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("START_TIME", 0);
        }
        return 0;
    }

    static BannerAdListener m1697x() {
        return f560H;
    }

    public String m1735y() {
        return this.f566F;
    }

    static boolean m1698z() {
        return f559G;
    }

    public int m1699A() {
        return this.f567I;
    }

    private int m1687H() throws Exception {
        Display defaultDisplay = ((WindowManager) this.f568a.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < EVENT_BANNER_CLICK) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    protected static int m1695c(Context context) throws Exception {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < EVENT_BANNER_CLICK) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    private String[] m1692a(String str, JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            Util.m929a(str + " Beacon: " + Arrays.toString(strArr));
            return strArr;
        } catch (JSONException e) {
            Util.m929a("Beacon parse: " + e.getMessage());
            return null;
        }
    }

    public String[] m1700B() {
        return this.f561A;
    }

    public String[] m1701C() {
        return this.f562B;
    }

    public void m1709a(String[] strArr) {
        this.f561A = strArr;
    }

    public void m1713b(String[] strArr) {
        this.f562B = strArr;
    }

    public boolean m1702D() {
        return this.f563C;
    }

    public long m1703E() {
        return this.f564D;
    }

    public int m1704F() {
        return this.f565E;
    }
}
