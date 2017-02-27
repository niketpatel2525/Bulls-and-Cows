package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.internal.C0198d;
import com.google.android.gms.maps.model.internal.C0198d.C0535a;

/* renamed from: com.google.android.gms.maps.internal.f */
public interface C0173f extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.f.a */
    public static abstract class C0506a extends Binder implements C0173f {

        /* renamed from: com.google.android.gms.maps.internal.f.a.a */
        private static class C0505a implements C0173f {
            private IBinder dG;

            C0505a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1556e(C0198d c0198d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    obtain.writeStrongBinder(c0198d != null ? c0198d.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0506a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        public static C0173f m1557Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0173f)) ? new C0505a(iBinder) : (C0173f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    m718e(C0535a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m718e(C0198d c0198d) throws RemoteException;
}
