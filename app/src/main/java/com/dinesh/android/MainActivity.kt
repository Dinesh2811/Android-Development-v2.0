package com.dinesh.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinesh.android.java.app.nav_drawer.NavMain
import com.dinesh.android.java.app.nav_drawer.NavigationDrawer
import com.dinesh.android.java.app.tab_layout.TabLayoutMain
import com.dinesh.android.ui.theme.AndroidDevelopmentV20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevelopmentV20Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }


        startActivity(Intent(this, TabLayoutMain::class.java))
//        startActivity(Intent(this, NavMain::class.java))
        finish()

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidDevelopmentV20Theme {
        Greeting("Android")
    }
}