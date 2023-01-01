package com.dinesh.android.kotlin.app

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.dinesh.android.R
import com.dinesh.android.databinding.ActivityMainBinding
import kotlin.system.exitProcess

private val TAG = "log_" + MainActivity::class.java.name.split(MainActivity::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class MainActivity : ToolbarMain() {

    lateinit var textView: TextView
    override var pressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.ActivityMain_TextView)

        setToolbar()

        textView.setOnClickListener {
            Log.d(TAG, "onCreate: ActivityMain_TextView")
            Toast.makeText(this@MainActivity, "ActivityMain_TextView", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        toolbar.setNavigationOnClickListener {
            if (pressedTime + 2000 > System.currentTimeMillis()) {
                finish()
                finishAndRemoveTask()
                finishAffinity()
                exitProcess(0)
            } else {
                Log.d(TAG, "onPrepareOptionsMenu: Press back again to exit")
                Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
            }
            pressedTime = System.currentTimeMillis()
        }

        tvToolbar = findViewById<View>(R.id.tvToolbar) as TextView
        tvToolbar.setOnClickListener {
            Log.d(TAG, "onPrepareOptionsMenu: Testing...")
            Toast.makeText(this@MainActivity, "Testing...", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when (id) {
            androidx.appcompat.R.id.home -> {
                Log.d(TAG, "onOptionsItemSelected: androidx.appcompat.R.id.home")
                Toast.makeText(this, TAG, Toast.LENGTH_LONG).show()
                true
            }
            R.id.menuAdmin -> {
                Log.d(TAG, "onOptionsItemSelected: Admin Testing")
                Toast.makeText(this, "Admin Testing", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
