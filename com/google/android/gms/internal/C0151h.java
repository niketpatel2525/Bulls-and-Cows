package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.h */
public class C0151h {
    private final C0113c dA;
    private String dw;
    private String dx;
    private String[] dy;
    private C0132d dz;

    public C0151h(C0132d c0132d) {
        this.dw = "googleads.g.doubleclick.net";
        this.dx = "/pagead/ads";
        this.dy = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.dA = new C0113c();
        this.dz = c0132d;
    }

    private Uri m661a(Uri uri, Context context, String str, boolean z) throws C0152i {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C0152i("Query parameter already exists: ms");
            }
            return m662a(uri, "ms", z ? this.dz.m336a(context, str) : this.dz.m335a(context));
        } catch (UnsupportedOperationException e) {
            throw new C0152i("Provided Uri is not in a valid state");
        }
    }

    private Uri m662a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    public Uri m663a(Uri uri, Context context) throws C0152i {
        try {
            return m661a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0152i("Provided Uri is not in a valid state");
        }
    }

    public void m664a(MotionEvent motionEvent) {
        this.dz.m338a(motionEvent);
    }

    public boolean m665a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.dy) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public C0132d m666g() {
        return this.dz;
    }
}
