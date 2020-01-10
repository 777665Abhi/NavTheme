package com.abhi.qualixlab

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhi.qualixlab.adapter.ItemAdapter
import com.abhi.qualixlab.setting.SettingActivity
import com.abhi.qualixlab.utils.SharedData
import com.abhi.qualixlab.utils.Utils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.home_content.*
import kotlinx.android.synthetic.main.nav_bottom_sheet.*
import java.util.*
import kotlin.collections.ArrayList


class HomeActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    AdapterOnClick {

    /**Adapter Item click Listener*/
    override fun onClick(item: Any) {
        Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        //Is bottom nav active
        if (SharedData.getNav(this) == Utils.NAV_BOTTOM) {
            bottomSheetBehavior!!.isHideable = true
            bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_HIDDEN)
        } else {
            drawer_layout.closeDrawer(Gravity.LEFT)
        }
    }


    var bottomSheetBehavior: BottomSheetBehavior<NestedScrollView>? = null
    var mAdapter: ItemAdapter? = null
    var optionData = ArrayList<OptionData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getDataReady(5)
        //set theme


            //Is bottom nav active
        if (SharedData.getNav(this) == Utils.NAV_BOTTOM) {
            setContentView(R.layout.home_content)
            setSupportActionBar(toolbar)
            val action = supportActionBar
            action!!.title = getString(R.string.app_name)

            showBottomNav()

        } else {
            setContentView(R.layout.activity_home)
            showSideNav()
            setSupportActionBar(toolbar)
            val action = supportActionBar
            action!!.title = getString(R.string.app_name)
            val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)
            drawer_layout.addDrawerListener(toggle)
            toggle.syncState()
        }


        bnAction.setOnClickListener {
            bottomSheetBehavior!!.isHideable = false
            bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
        }

        bottomNavigation.setOnNavigationItemSelectedListener(this)

        /** Bottom Sheet */
        bottomSheetBehavior = BottomSheetBehavior.from(nestedScrollView)

        bottomSheetBehavior!!.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
            }

            override fun onStateChanged(p0: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }
        })
    }

    fun getDataReady(limit: Int) {
        for (i in 0 until limit) {
            optionData.add(OptionData(i, "Opt$i"))
        }
    }


    /**----------------------------Option menu*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.setting -> {
                Utils.moveNextScreen(this, SettingActivity::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**----------------------------Bottom Navigation*/
    /*1 Hide Side nav
    * 2 Show Bottom nav
    * 3 Set Bottom sheet Data */
    fun showBottomNav() {
//        nav_view.visibility = View.GONE
//        nav_bottom.visibility = View.VISIBLE
//        bottomNavigation.visibility = View.VISIBLE
        if (optionData.size > 0) {
            bottomNavigation.visibility = View.VISIBLE
            var menu = bottomNavigation.menu

            menu.add(Menu.NONE, optionData[0].opId, Menu.NONE, optionData[0].opTitle)
                .setIcon(R.drawable.ic_option)
            menu.add(Menu.NONE, optionData[1].opId, Menu.NONE, optionData[1].opTitle)
                .setIcon(R.drawable.ic_option)
            menu.add(Menu.NONE, optionData[2].opId, Menu.NONE, optionData[2].opTitle)
                .setIcon(R.drawable.ic_option)

            //More option is defined
            if (optionData.size > 3) {
                menu.add("More").setIcon(R.drawable.ic_option)
                recyclerViewBottom.setHasFixedSize(true)
                recyclerViewBottom.layoutManager = LinearLayoutManager(this)
                val items = ArrayList<String>()
                for (i in 3 until optionData.size) {
                    items.add(optionData[i].opTitle)
                }
                mAdapter = ItemAdapter(items, this, this)
                recyclerViewBottom.adapter = mAdapter
            }
        }

    }

    /*Bottom NavigationItem Selected listener*/
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.title) {
            "More" -> {
                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> {
                Toast.makeText(this, menuItem.title, Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

//    nav_drawer_recycler_view

    fun showSideNav() {

//        nav_view.visibility = View.VISIBLE
        nav_bottom.visibility = View.GONE
        bottomNavigation.visibility = View.GONE
        nav_drawer_recycler_view.setHasFixedSize(true)
        nav_drawer_recycler_view.layoutManager = LinearLayoutManager(this)
        val items = ArrayList<String>()
        for (i in 0 until optionData.size) {
            items.add(optionData[i].opTitle)
        }
        mAdapter = ItemAdapter(items, this, this)
        nav_drawer_recycler_view.adapter = mAdapter
    }


}

interface AdapterOnClick {
    fun onClick(item: Any)
}
