package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.google.android.gms.games.GamesClient;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.XmlParser.Creative;
import com.sxnyodot.uefqvmio207964.XmlParser.InvalidVastXML;
import com.sxnyodot.uefqvmio207964.XmlParser.VastException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.sxnyodot.uefqvmio207964.t */
class C0564t implements C0292b<String> {
    private static final String TAG = "PrmVast";
    private static XmlParser f609a;
    private Context f610b;

    /* renamed from: com.sxnyodot.uefqvmio207964.t.1 */
    class C05631 implements C0292b<String> {
        String f604a;
        final /* synthetic */ String f605b;
        final /* synthetic */ boolean f606c;
        final /* synthetic */ String f607d;
        final /* synthetic */ C0564t f608e;

        /* renamed from: com.sxnyodot.uefqvmio207964.t.1.1 */
        class C03201 implements Runnable {
            final /* synthetic */ C05631 f430a;

            C03201(C05631 c05631) {
                this.f430a = c05631;
            }

            public void run() {
                try {
                    URLConnection openConnection = new URL(this.f430a.f607d).openConnection();
                    openConnection.setConnectTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                    openConnection.setReadTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                    openConnection.connect();
                    Log.i(C0564t.TAG, "Content-length: " + openConnection.getContentLength());
                    InputStream inputStream = openConnection.getInputStream();
                    File file = new File(this.f430a.f604a, "ad_video.mp4");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.close();
                            this.f430a.m1755a(file.getAbsolutePath());
                            return;
                        }
                    }
                } catch (SocketTimeoutException e2) {
                    e2.printStackTrace();
                    this.f430a.m1755a(null);
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                    this.f430a.m1755a(null);
                } catch (IOException e4) {
                    e4.printStackTrace();
                    this.f430a.m1755a(null);
                }
            }
        }

        C05631(C0564t c0564t, String str, boolean z, String str2) {
            this.f608e = c0564t;
            this.f605b = str;
            this.f606c = z;
            this.f607d = str2;
            this.f604a = "";
        }

        public void m1755a(String str) {
            Util.m929a("Video file: " + str);
            if (str != null) {
                try {
                    if (!str.equals("")) {
                        if (Prm.enableCaching) {
                            C0294d c0294d = new C0294d(this.f608e.f610b);
                            if (c0294d.m1010a(AdType.video, this.f605b, str)) {
                                if (this.f606c) {
                                    c0294d.m1009a(AdType.smartwall, this.f605b);
                                    C0561p.sendAdCached(AdType.smartwall);
                                    c0294d.m1007a(true);
                                    return;
                                }
                                C0561p.sendAdCached(AdType.video);
                                return;
                            } else if (Prm.adListener != null) {
                                C0561p.sendAdError("Video ad not cached.");
                                return;
                            } else {
                                return;
                            }
                        }
                        Intent intent = new Intent(this.f608e.f610b, VDActivity.class);
                        intent.setAction("play_video");
                        intent.setFlags(268435456);
                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                        intent.addFlags(536870912);
                        intent.setData(Uri.parse(str));
                        this.f608e.f610b.startActivity(intent);
                        C0562q.m1748d(this.f608e.f610b);
                        return;
                    }
                } catch (Throwable e) {
                    Log.e(C0564t.TAG, "Error occured while download video", e);
                    return;
                }
            }
            Log.e(C0564t.TAG, "Not able to download video");
        }

        public void m1753a() {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "ap_video");
                if (file.exists() && file.isDirectory()) {
                    VU.m999a(file);
                    file.mkdirs();
                    this.f604a = file.getAbsolutePath();
                } else if (file.mkdirs()) {
                    this.f604a = file.getAbsolutePath();
                }
                new Thread(new C03201(this), "dwn_video").start();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
            }
        }
    }

    static XmlParser m1759b() {
        return f609a;
    }

    public C0564t(Context context) {
        this.f610b = context;
    }

    public void m1760a() {
        try {
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("cache", Prm.cache));
            new Thread(new C0304m(this.f610b, this, arrayList, C0300h.VIDEO_AD_URL, 0, true), "vast").start();
        } catch (Throwable e) {
            Log.e(TAG, "Video ad", e);
        } catch (Throwable e2) {
            Log.e(TAG, "Error occurred while fetching Video ad", e2);
        }
    }

    public void m1762a(String str) {
        Log.i(TAG, "Video Ad: " + str);
        if (str == null || str.equals("")) {
            Log.w(TAG, "Video ad response is null");
        } else {
            m1764a(str, false);
        }
    }

    void m1764a(String str, boolean z) {
        try {
            C0562q.m1748d(this.f610b);
            f609a = new XmlParser(new StringReader(str));
            HashMap hashMap = (HashMap) ((Creative) f609a.m1683m().get(0)).getMediaFiles().get(0);
            String obj = hashMap.get(C0303k.MEDIA_FILE).toString();
            String obj2 = hashMap.get(C0303k.MEDIA_FILE_DELIVERY).toString();
            if (obj == null || obj.equals("")) {
                Log.e(TAG, "Ad url is invalid: " + obj);
            } else if (obj2 != null && obj2.equals("progressive")) {
                m1757a(str, obj, z);
            } else if (Prm.enableCaching) {
                C0294d c0294d = new C0294d(this.f610b);
                if (!c0294d.m1010a(AdType.video, str, obj)) {
                    return;
                }
                if (z) {
                    c0294d.m1009a(AdType.smartwall, str);
                    C0561p.sendAdCached(AdType.smartwall);
                    c0294d.m1007a(true);
                    return;
                }
                C0561p.sendAdCached(AdType.video);
            } else {
                Log.e(TAG, "deleviery type streaming " + obj);
                Intent intent = new Intent(this.f610b, VDActivity.class);
                intent.setAction("play_video");
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                intent.addFlags(536870912);
                intent.setData(Uri.parse(obj));
                this.f610b.startActivity(intent);
                C0562q.m1748d(this.f610b);
            }
        } catch (VastException e) {
            Log.e(TAG, e.getMessage());
            Prm.validateStatusCode(e.getCode(), e.getMessage());
        } catch (InvalidVastXML e2) {
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m1757a(String str, String str2, boolean z) {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            boolean z2 = externalStorageState.equals("mounted") && !externalStorageState.equals("mounted_ro");
            if (Boolean.valueOf(z2).booleanValue()) {
                C0292b c05631 = new C05631(this, str, z, str2);
                if (Util.m977o(this.f610b)) {
                    c05631.m1004a();
                    return;
                }
                return;
            }
            String str3 = "SD Card  is not available for caching video. SD Card storage state: " + externalStorageState;
            Log.e(TAG, str3);
            C0561p.sendAdError(str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean m1758a(Context context) {
        boolean z = true;
        try {
            if (!(context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                String str = "Required permission WRITE_EXTERNAL_STORAGE not found in Manifest. Please add.";
                Log.e(C0300h.TAG, str);
                C0561p.sendIntegrationError(str);
                z = false;
            }
            if (z) {
                return z;
            }
            C0311o c0311o = new C0311o(context, 110);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void m1763a(String str, String str2) {
        try {
            f609a = new XmlParser(new StringReader(str));
            Log.i(TAG, "Showing ad from caching; " + str2);
            Intent intent = new Intent(this.f610b, VDActivity.class);
            intent.setAction("play_video");
            intent.setFlags(268435456);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.addFlags(536870912);
            intent.setData(Uri.parse(str2));
            this.f610b.startActivity(intent);
            C0562q.m1748d(this.f610b);
        } catch (Throwable th) {
            Log.e(TAG, "Error occurred while showing video from cache", th);
        }
    }
}
