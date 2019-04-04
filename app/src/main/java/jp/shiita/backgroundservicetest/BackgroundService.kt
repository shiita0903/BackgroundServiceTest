package jp.shiita.backgroundservicetest

import android.app.IntentService
import android.content.Intent
import android.util.Log

class BackgroundService : IntentService("BackgroundService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("BackgroundService", "onHandleIntent")
        repeat(100) {
            Log.d("BackgroundService", "sleep:$it")
            Thread.sleep(it.toLong() * 1000)
            MyJobIntentService.enqueueWork(this, 1000 + it * 10)
        }
    }
}