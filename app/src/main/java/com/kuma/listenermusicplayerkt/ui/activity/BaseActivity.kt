package com.kuma.listenermusicplayerkt.ui.activity

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.AsyncTask
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.appthemeengine.ATEActivity

/**
 * name: BaseActivity
 * author: 熊熊熊
 * date: 2022/10/12 22:18
 * description:
 */
open class BaseActivity : AppCompatActivity(), ServiceConnection {


    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        TODO("Not yet implemented")
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        TODO("Not yet implemented")
    }

class initQuickControls:AsyncTask<String,Void,String>(){
    override fun doInBackground(vararg params: String?): String {
return ""
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }
}
}