package jp.shiita.backgroundservicetest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        MyJobIntentService.enqueueWork(this, 100)
        startService(Intent(this, BackgroundService::class.java))

        // ホームに戻り1分程度待つと、アプリがクラッシュする
//        startService(Intent(this, BackgroundService2::class.java))
    }
}
