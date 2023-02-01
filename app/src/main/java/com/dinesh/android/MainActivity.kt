package com.dinesh.android

import android.Manifest
import android.R
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.dinesh.android.java.activity.GoTo_Class
import com.dinesh.android.java.activity.LayoutInflater_Class
import com.dinesh.android.java.request_permission.MultipleUserPermission
import com.dinesh.android.kotlin.app.user_interface.CustomProgressBar
import com.dinesh.android.kotlin.app.user_interface.FancyDialog
import com.dinesh.android.kotlin.app.user_interface.FancySnackbar
import com.dinesh.android.kotlin.request_permission.ExternalStorage
import com.dinesh.android.root.RvChildModel
import com.dinesh.android.root.RvMain
import com.google.android.material.snackbar.Snackbar

//import com.dinesh.android.root.TestRvData.setClassList
//import com.dinesh.android.root.TestRvData.setRvChildModelList
//import com.dinesh.android.root.TestRvData.setRvParentModelList
//import com.dinesh.android.root.TestRvData.setStringList

private val TAG = "log_" + MainActivity::class.java.name.split(MainActivity::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        startActivity(Intent(this, RvMain::class.java))
//        finish()


    }
}