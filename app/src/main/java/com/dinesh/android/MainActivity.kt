package com.dinesh.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinesh.android.kotlin.app.ToolbarMain
import com.dinesh.android.root.RvMain

private val TAG = "log_" + MainActivity::class.java.name.split(MainActivity::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                RootUI(
//                    "Dinesh"
//                )
//            }
//        }


        startActivity(Intent(this, RvMain::class.java))
//        startActivity(Intent(this, ToolbarMain::class.java))
//        startActivity(Intent(this, com.dinesh.android.kotlin.app.MainActivity::class.java))
//        startActivity(Intent(this, NavMain::class.java))
        finish()

    }
}

@Composable
fun RootUI(
    name: String = "Android",
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RootUI()
}