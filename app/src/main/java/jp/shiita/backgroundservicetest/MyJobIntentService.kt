package jp.shiita.backgroundservicetest

import android.content.Context
import android.content.Intent
import android.support.v4.app.JobIntentService
import android.util.Log

class MyJobIntentService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        val num = intent.getIntExtra(ARGS_NUM, 0)
        Log.d("MyJobIntentService", "onHandleWork : $num")
    }

    companion object {
        private const val ARGS_NUM = "argsNum"
        private const val JOB_ID = 1

        fun enqueueWork(context: Context, num: Int) {
            val intent = Intent(context, MyJobIntentService::class.java).apply { putExtra(ARGS_NUM, num) }
            JobIntentService.enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent)
        }
    }
}