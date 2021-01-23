package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class Splasher extends AppCompatActivity {
    BroadcastReceiver mReceiver;
    public static boolean splasherKontrol=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        IntentFilter filt = new IntentFilter(Intent.ACTION_USER_PRESENT);
        //   filt.addAction(Intent.ACTION_SCREEN_ON);
        mReceiver = new UserPresentReciever();
        registerReceiver(mReceiver, filt);
            /*Thread zaman = new Thread() {
                public void run() {
                    try {
                        sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.i("tago", "giriş ekranı çalışmadı");//Log ile sadece geliştirme aşamasında bizim görebileceğimiz mesajlar alabiliyoruz
                    } finally {
                        Intent i = new Intent(Splasher.this, Anasayfa.class);
                        startActivity(i);
                    }
                }

            };//işlem class
         //   if(!splasherKontrol) {
              //  splasherKontrol=true;
                zaman.start();//Thread çalıştı manifestte gerekli değişiklikler yapıldı
           // }
*/
        startActivity(new Intent(Splasher.this,Anasayfa.class));
        finish();


    }

    @Override
    protected void onDestroy(){ //Activity Kapatıldığı zaman receiver durduralacak.Uygulama arka plana alındığı zamanda receiver çalışmaya devam eder

        super.onDestroy();


        unregisterReceiver(mReceiver);
    }

}
