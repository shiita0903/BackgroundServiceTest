package jp.shiita.backgroundservicetest

import android.app.IntentService
import android.content.Intent
import android.util.Log

class BackgroundService2 : IntentService("BackgroundService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("BackgroundService2", "onHandleIntent")
        repeat(100) {
            Log.d("BackgroundService2", "sleep:$it")
            Thread.sleep(it.toLong() * 1000)
            // そもそもJobIntentServiceをstartServiceで起動してはいけないはず
            startService(Intent(this, MyJobIntentService::class.java).apply { putExtra("argsNum", 1000 + it * 10) })
        }
    }
}