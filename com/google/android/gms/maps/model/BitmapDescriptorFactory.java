package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.model.internal.C0195a;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static C0195a pZ;

    private BitmapDescriptorFactory() {
    }

    public static void m732a(C0195a c0195a) {
        if (pZ == null) {
            pZ = (C0195a) dm.m392e(c0195a);
        }
    }

    private static C0195a cL() {
        return (C0195a) dm.m388a(pZ, (Object) "IBitmapDescriptorFactory is not initialized");
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(cL().cQ());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor defaultMarker(float hue) {
        try {
            return new BitmapDescriptor(cL().m758c(hue));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromAsset(String assetName) {
        try {
            return new BitmapDescriptor(cL().m754S(assetName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap image) {
        try {
            return new BitmapDescriptor(cL().m757a(image));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromFile(String fileName) {
        try {
            return new BitmapDescriptor(cL().m755T(fileName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromPath(String absolutePath) {
        try {
            return new BitmapDescriptor(cL().m756U(absolutePath));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromResource(int resourceId) {
        try {
            return new BitmapDescriptor(cL().ad(resourceId));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
