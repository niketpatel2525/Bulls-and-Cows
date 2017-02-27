package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.util.Log;
import android.webkit.WebView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* renamed from: com.sxnyodot.uefqvmio207964.q */
class C0562q implements C0300h {
    static JSONObject f599a;
    static List<NameValuePair> f600b;
    private static Context f601c;
    private static String f602d;
    private static SharedPreferences f603e;

    static {
        f599a = null;
        f602d = "0";
    }

    public C0562q(Context context) {
        f601c = context;
    }

    void m1752a() {
        try {
            Util.m954g(new WebView(f601c).getSettings().getUserAgentString());
            C0319s c0319s = new C0319s(f601c);
            try {
                if (!C0562q.m1751g(f601c)) {
                    Location d = c0319s.m1049d();
                    if (d != null) {
                        String str = "" + d.getLatitude();
                        String str2 = "" + d.getLongitude();
                        Util.m962j(c0319s.m1048c());
                        Util.m926a(d.getAccuracy());
                        Util.m966k(d.getProvider());
                        Util.m929a("Location: lat " + str + ", lon " + str2);
                        Util.m957h(str);
                        Util.m960i(str2);
                    } else {
                        Util.m929a("Location null: ");
                    }
                }
            } catch (Exception e) {
            }
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                c = "NOT FOUND";
            }
            f602d = (C0562q.m1751g(f601c) ? Util.m952g() : Util.m972m(c)) + "" + Util.m961j() + "" + Util.m982r();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(f602d.getBytes(), 0, f602d.length());
            f602d = new BigInteger(1, instance.digest()).toString(16);
        } catch (Exception e2) {
            Util.m929a("Token conversion Error ");
        }
    }

    static List<NameValuePair> m1744a(Context context) throws NullPointerException, Exception {
        f601c = context;
        f600b = new ArrayList();
        if (C0562q.m1751g(context)) {
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                throw new NullPointerException("Advertising id not avalaible");
            }
            f600b.add(new BasicNameValuePair(C0300h.IMEI, Util.m972m(c)));
            f600b.add(new BasicNameValuePair(C0300h.IMEI_SHA, Util.m975n(c)));
            f600b.add(new BasicNameValuePair(C0300h.DEVICE_UNIQUENESS, "ADV"));
        } else if (Util.m952g() == null || Util.m952g().length() == 0) {
            throw new NullPointerException("IMEI is empty");
        } else {
            f600b.add(new BasicNameValuePair(C0300h.IMEI, Util.m952g()));
            f600b.add(new BasicNameValuePair(C0300h.IMEI_SHA, Util.m956h()));
            f600b.add(new BasicNameValuePair(C0300h.DEVICE_UNIQUENESS, Util.m989w()));
            f600b.add(new BasicNameValuePair(C0300h.ANDROID_ID, Util.m941c(f601c)));
            f600b.add(new BasicNameValuePair(C0300h.ANDROID_ID_SHA, Util.m943d(f601c)));
            f600b.add(new BasicNameValuePair(C0300h.LONGITUDE, Util.m970m()));
            f600b.add(new BasicNameValuePair(C0300h.LATITUDE, Util.m967l()));
            f600b.add(new BasicNameValuePair("locProvider", "" + Util.m980q()));
            f600b.add(new BasicNameValuePair("locType", "" + Util.m976o()));
            f600b.add(new BasicNameValuePair("locAccuracy", "" + Util.m978p()));
            try {
                String[] l = Util.m969l(f601c);
                f600b.add(new BasicNameValuePair(C0300h.COUNTRY, "" + l[0]));
                f600b.add(new BasicNameValuePair(C0300h.ZIP, "" + l[1]));
            } catch (NullPointerException e) {
            } catch (Exception e2) {
            }
        }
        if (Util.m961j() == null || Util.m961j().length() == 0) {
            throw new NullPointerException("Appid is empty");
        }
        f600b.add(new BasicNameValuePair(C0300h.APIKEY, Util.m958i()));
        f600b.add(new BasicNameValuePair(C0300h.APP_ID, Util.m961j()));
        f600b.add(new BasicNameValuePair(C0300h.TOKEN, f602d));
        f600b.add(new BasicNameValuePair(C0300h.REQUEST_TIMESTAMP, Util.m982r()));
        f600b.add(new BasicNameValuePair(C0300h.PACKAGE_NAME, Util.m947e(f601c)));
        f600b.add(new BasicNameValuePair(C0303k.VERSION, Util.m986t()));
        f600b.add(new BasicNameValuePair(C0300h.CARRIER, Util.m950f(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.NETWORK_OPERATOR, Util.m953g(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.PHONE_MODEL, Util.m984s()));
        f600b.add(new BasicNameValuePair(C0300h.MANUFACTURER, Util.m988v()));
        f600b.add(new BasicNameValuePair(C0300h.SDK_VERSION, Util.m925a()));
        f600b.add(new BasicNameValuePair(C0300h.WIFI, "" + Util.m955h(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.USER_AGENT, Util.m964k()));
        f600b.add(new BasicNameValuePair(C0300h.SCREEN_SIZE, Util.m965k(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.NETWORK_SUBTYPE, Util.m959i(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.isTABLET, String.valueOf(Util.m932a(f601c))));
        f600b.add(new BasicNameValuePair(C0300h.SCREEN_DENSITY, Util.m971m(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.isCONNECTION_FAST, "" + Util.m963j(f601c)));
        f600b.add(new BasicNameValuePair(C0300h.UNKNOWN_SOURCE, "" + Util.m981q(f601c)));
        f600b.add(new BasicNameValuePair("appName", Util.m979p(f601c)));
        f600b.add(new BasicNameValuePair("dpi", Util.m974n(f601c)));
        f600b.add(new BasicNameValuePair("src", "premium"));
        f600b.add(new BasicNameValuePair("sessionId", Util.m946e()));
        f600b.add(new BasicNameValuePair(C0300h.LANGUAGE, "" + Util.m990x()));
        f600b.add(new BasicNameValuePair("locale", "" + Locale.getDefault()));
        f600b.add(new BasicNameValuePair("adv_id", "" + Util.m940c()));
        f600b.add(new BasicNameValuePair("adOpt", "" + Util.m939b()));
        return f600b;
    }

    static boolean m1746b(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            f603e = null;
            f603e = context.getSharedPreferences("next_ad_call", 0);
            Editor edit = f603e.edit();
            long currentTimeMillis = 10000 + System.currentTimeMillis();
            edit.putLong(C0300h.START_TIME, currentTimeMillis);
            z = edit.commit();
            Log.i(C0300h.TAG, "Next Smart Wall ad call time: " + new Date(currentTimeMillis).toString());
            return z;
        } catch (Exception e) {
            return z;
        }
    }

    static long m1747c(Context context) {
        f603e = null;
        if (context == null) {
            return 0;
        }
        f603e = context.getSharedPreferences("next_ad_call", 0);
        if (f603e != null) {
            return f603e.getLong(C0300h.START_TIME, 0);
        }
        return 0;
    }

    static boolean m1748d(Context context) {
        boolean z = false;
        try {
            f603e = null;
            f603e = context.getSharedPreferences("video_ad_call", 0);
            Editor edit = f603e.edit();
            long currentTimeMillis = 30000 + System.currentTimeMillis();
            edit.putLong(C0300h.START_TIME, currentTimeMillis);
            Util.m929a("Next Video ad ad call time: " + new Date(currentTimeMillis).toString());
            z = edit.commit();
        } catch (Exception e) {
        }
        return z;
    }

    static long m1749e(Context context) {
        f603e = null;
        if (context == null) {
            return 0;
        }
        f603e = context.getSharedPreferences("video_ad_call", 0);
        if (f603e != null) {
            return f603e.getLong(C0300h.START_TIME, 0);
        }
        return 0;
    }

    static void m1750f(Context context) {
        try {
            Editor edit = context.getSharedPreferences("firstTime", 0).edit();
            edit.putBoolean("showDialog", false);
            edit.putString("adv_id", Util.m940c());
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean m1751g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("firstTime", 0);
        String string = sharedPreferences.getString("adv_id", "");
        String c = Util.m940c();
        if (sharedPreferences.getBoolean("showDialog", true)) {
            return true;
        }
        if (string.equals("") || c == null || c.length() <= 0 || string.equalsIgnoreCase(c)) {
            return false;
        }
        return true;
    }

    static void m1745a(Activity activity) {
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences(C0300h.ENABLE_AD_PREF, 0);
            Prm prm = new Prm(activity);
            if (sharedPreferences.contains(C0300h.INTERSTITAL_AD_STRING) && sharedPreferences.getBoolean(C0300h.INTERSTITAL_AD_STRING, false)) {
                prm.runSmartWallAd();
            }
            if (sharedPreferences.contains(C0300h.OVERLAY_AD) && sharedPreferences.getBoolean(C0300h.OVERLAY_AD, false)) {
                prm.runOverlayAd();
            }
            if (sharedPreferences.contains(C0300h.APP_WALL_AD) && sharedPreferences.getBoolean(C0300h.APP_WALL_AD, false)) {
                prm.runAppWall();
            }
            if (sharedPreferences.contains(C0300h.VIDEO_AD) && sharedPreferences.getBoolean(C0300h.VIDEO_AD, false)) {
                prm.runVideoAd();
            }
            if (sharedPreferences.contains(C0300h.RICH_MEDIA) && sharedPreferences.getBoolean(C0300h.RICH_MEDIA, false)) {
                prm.runRichMediaInterstitialAd();
            }
        } catch (Throwable e) {
            Util.m930a("Error occured in eap: ", e);
        }
    }
}
