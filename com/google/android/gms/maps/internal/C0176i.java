package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.maps.internal.i */
public interface C0176i extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.i.a */
    public static abstract class C0512a extends Binder implements C0176i {

        /* renamed from: com.google.android.gms.maps.internal.i.a.a */
        private static class C0511a implements C0176i {
            private IBinder dG;

            C0511a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void onMapLoaded() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0512a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
        }

        public static C0176i m1561T(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0176i)) ? new C0511a(iBinder) : (C0176i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    onMapLoaded();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onMapLoaded() throws RemoteException;
}
