package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0070b;
import com.google.android.gms.dynamic.C0070b.C0357a;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.maps.internal.g */
public interface C0174g extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.g.a */
    public static abstract class C0508a extends Binder implements C0174g {

        /* renamed from: com.google.android.gms.maps.internal.g.a.a */
        private static class C0507a implements C0174g {
            private IBinder dG;

            C0507a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1558g(C0070b c0070b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(c0070b != null ? c0070b.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0174g m1559R(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0174g)) ? new C0507a(iBinder) : (C0174g) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    m719g(C0357a.m1114z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m719g(C0070b c0070b) throws RemoteException;
}
