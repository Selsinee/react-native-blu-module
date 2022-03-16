package com.reactnativeblumodule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.blusdk.BluSdk
import com.blusdk.BluView
import com.blusdk.log.BluLogType
import com.blusdk.webview.BluWebView

/**
 * Created by Seline on 15/03/2022 11:04
 */
class BluView : AppCompatActivity(), BluWebView.IBluWebViewListener {

  private lateinit var bluView: BluView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.bluview_activity)
    bluView = findViewById(R.id.blu_view)

    BluSdk.initialize(this, BluSdk.ENV_DEV, "app-blu-binusstudent-dev")
    bluView.setWebViewListener(this)
    bluView.setContextParent(this)
  }

  override fun onBackPressed() {
    if (bluView.hasHandleBackPress()) bluView.onBackPressed()
    else super.onBackPressed()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    bluView.handleActivityResult(requestCode, resultCode, data)
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    bluView.onRequestPermissionsResult(requestCode, permissions, grantResults)
  }

  override fun onDestroy() {
    BluSdk.destroy()
    super.onDestroy()
  }

  override fun bluLog(type: BluLogType, message: String?, error: Throwable?) {
    Log.d("<LOG>", "Type: " + type.toString() + " " + message.toString())
  }

  override fun onClose() {
    TODO("Not yet implemented")
  }

  override fun onLinkageFailed() {
    TODO("Not yet implemented")
  }

}
