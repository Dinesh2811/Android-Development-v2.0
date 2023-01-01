package com.dinesh.android.kotlin.app

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.dinesh.android.R
import kotlin.system.exitProcess

private val TAG = "log_" + ToolbarMain::class.java.name.split(ToolbarMain::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]


open class ToolbarMain : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var tvToolbar: TextView
    lateinit var toolbarSearchView: SearchView
    open var pressedTime: Long = 0

    private val toolbarBackground : Int = R.color.white
    private val toolbarOnBackground : Int = R.color.black



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbar_layout)

        setToolbar()
        toolbar.setNavigationOnClickListener {
            if (pressedTime + 2000 > System.currentTimeMillis()) {
                finish()
                finishAndRemoveTask()
                finishAffinity()
                exitProcess(0)
            } else {
                Log.d(TAG, "onCreate: Press back again to exit")
                Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
            }
            pressedTime = System.currentTimeMillis()
        }
    }

    fun setToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbarSearchView = findViewById(R.id.toolbarSearchView)
        setSupportActionBar(toolbar)

        toolbarSearchView.setQuery("bhb",true)

//        // Enable the back button on the toolbar
//        supportActionBar!!.setDisplayShowHomeEnabled(true)
//        supportActionBar!!.setHomeButtonEnabled(true)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        tvToolbar = findViewById(R.id.tvToolbar)
        tvToolbar.setTextColor(ContextCompat.getColor(this, toolbarOnBackground))
        toolbar.setBackgroundColor(ContextCompat.getColor(this, toolbarBackground))


//        toolbar!!.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        val navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24)
        navigationIcon!!.setTint(ContextCompat.getColor(this, toolbarOnBackground))
        toolbar.navigationIcon = navigationIcon

//        toolbar!!.setCollapseIcon(R.drawable.ic_baseline_arrow_back_24)
        val backCollapseIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24)
        navigationIcon.setTint(ContextCompat.getColor(this, toolbarOnBackground))
        toolbar.collapseIcon = backCollapseIcon

        var optionDrawableIcon = menu.findItem(R.id.menuMain).icon
        optionDrawableIcon = DrawableCompat.wrap(optionDrawableIcon!!)
        DrawableCompat.setTint(optionDrawableIcon, ContextCompat.getColor(this, toolbarOnBackground))
        menu.findItem(R.id.menuMain).icon = optionDrawableIcon

        var searchDrawableIcon = menu.findItem(R.id.action_search).icon
        searchDrawableIcon = DrawableCompat.wrap(searchDrawableIcon!!)
        DrawableCompat.setTint(searchDrawableIcon, ContextCompat.getColor(this, toolbarOnBackground))
        menu.findItem(R.id.action_search).icon = searchDrawableIcon

        val searchItem = menu.findItem(R.id.action_search)
        var searchView = searchItem.actionView as SearchView?
        searchView!!.setBackgroundColor(ContextCompat.getColor(this, toolbarBackground))
        searchView.queryHint = "Search Here"
        searchView.maxWidth = Int.MAX_VALUE
        searchView.isIconified = false

        searchView.setQuery(resources.getText(R.string.app_name),true)
        searchView.clearFocus()

        val searchClose = searchView.findViewById<View>(androidx.appcompat.R.id.search_close_btn) as ImageView
        val collapseIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_close_24)
        collapseIcon!!.setTint( ContextCompat.getColor(this, toolbarOnBackground))
        searchClose.background = collapseIcon
        searchClose.setImageResource(R.drawable.ic_baseline_close_24)
        searchClose.setBackgroundColor(ContextCompat.getColor(this, toolbarBackground))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when (id) {
            android.R.id.home -> {
                Log.d(TAG, "onOptionsItemSelected: Back Menu")
                Toast.makeText(this, "Back Menu", Toast.LENGTH_LONG).show()
                true
            }
            R.id.menuAdmin -> {
                Log.d(TAG, "onOptionsItemSelected: Item 1 Selected")
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.menuUser -> {
                Log.d(TAG, "onOptionsItemSelected: Item 2 Selected")
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.logout -> {
                Log.d(TAG, "onOptionsItemSelected: Log Out")
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_search -> {
                Log.d(TAG, "onOptionsItemSelected: action_search")
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

/*
 <item name="windowActionBar">false</item>
 <item name="windowNoTitle">true</item>
 */
