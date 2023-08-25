package com.example.humo.utils.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.humo.DasturInfo
import com.example.humo.R
import com.example.humo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import java.util.Locale
import kotlin.system.exitProcess

open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    //    private lateinit var navController: NavController
    private lateinit var nameTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        loadLocale()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repleceFragment(HomeFragment())


        binding.bottomNavigationView.selectedItemId = R.id.glavni
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.glavni -> repleceFragment(HomeFragment())
                R.id.adabiyotlar -> repleceFragment(ManzilFragment())
                R.id.medialar -> repleceFragment(MediyaFragment())

                else -> {

                }

            }
            true
        }
//        binding.bolimlar.setOnClickListener { bolimlar() }


        val drawerLayout: DrawerLayout = findViewById(R.id.home_manu)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        val headerView: View = navigationView.getHeaderView(0)
        nameTextView = headerView.findViewById(R.id.drawer_name)
        phoneTextView = headerView.findViewById(R.id.drawer_number)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        binding.backBtn1.setOnClickListener {
//            startActivity(Intent(this@CallFragment, MainActivity::class.java))
//            finish()
//        }

//        when (menuItem.itemId) {
//                R.id.nav_favourite -> {
//                    val intent = Intent(this@MainActivity, favourite::class.java)
//                    startActivity(intent)

        navigationView.setNavigationItemSelectedListener {
            if (!::sharedPreferences.isInitialized) {
                sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            }


            when (it.itemId) {

                R.id.foydalanuvchi -> {
                    showDeveloperinfo()
                }

                R.id.mexmonxonalar -> {
                    showDeveloperinfo()
                }
//                    val intent = Intent(this@MainActivity, TestUchun::class.java)
//                    startActivity(intent)
//                    finish()
                R.id.avia_chiptalar -> {
                    showDeveloperinfo()
                }

                R.id.visa -> {
                    val intent = Intent(this@MainActivity, VizaFragment::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.tayyor_tour -> {
                    showDeveloperinfo()
                }

                R.id.eksklyusiv_tour -> {
                    showDeveloperinfo()
                }

                R.id.Takliflar_uchun -> {

                    val intent = Intent(this@MainActivity, CallFragment::class.java)
                    startActivity(intent)
                    finish()

                }

                R.id.share_app -> {
                    showDeveloperinfo()
                }

                R.id.login_nav -> {
                    showDeveloperinfo()
                } // showInputDialog()
                R.id.dastur_info -> {
                    val intent = Intent(this@MainActivity, DasturInfo::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.exit_app -> exitProcess(1)
//                R.id.day_mode -> { showDeveloperinfo() }
//                R.id.night_mode -> { showDeveloperinfo() }
            }
            true
        }
    }


    @SuppressLint("InflateParams")
    fun showDeveloperinfo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val comingSonView = layoutInflater.inflate(R.layout.ishlab_chiqarishda, null)
        dialogBuilder.setView(comingSonView)
            .show()
    }


    fun callDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val intent = layoutInflater.inflate(R.layout.calll_item, null)
        dialogBuilder.setView(intent)
            .show()

    }


//    private fun showCallDialog() {
//        val dialogBuilder = AlertDialog.Builder(this)
//        val dialogView = layoutInflater.inflate(R.layout.calll_item, null)
//        dialogBuilder.setView(dialogView)
//            .show()
//        val dialogPhoneEditText = dialogView.findViewById<EditText>(R.id.callus)
//
//        dialogBuilder.setView(dialogView)
//            .setTitle("Ko'proq ma'lumotlarga ega bo'lishni istasangiz yuqoridagi raqamlardan biriga qo'ng'iroq qiling")
//            .setPositiveButton("Qo'ng'iroq qilish") { _, _ ->
////                val phoneNumber = dialogPhoneEditText.text.toString()
////                phoneTextView.text = phoneNumber
////                callPhoneNumber(phoneNumber)
//            }
//            .setNegativeButton("◀️") { _, _ ->
//                // Cancel button clicked
//            }
//            .show()
//    }

//    private fun callPhoneNumber(phoneNumber: String) {
//        val dialIntent = Intent(Intent.ACTION_DIAL)
//        dialIntent.data = Uri.parse("tel:$phoneNumber")
//        startActivity(dialIntent)
//    }

    private fun showInputDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.register_item, null)

        val dialogNameEditText = dialogView.findViewById<EditText>(R.id.user_name)
        val dialogPhoneEditText = dialogView.findViewById<EditText>(R.id.user_number)

        dialogBuilder.setView(dialogView)
            .setTitle("Ro'yxatdan o'ting")
            .setPositiveButton("Keyingisi") { _, _ ->
                val name = dialogNameEditText.text.toString()
                val phone = dialogPhoneEditText.text.toString()

                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("phone", phone)
                editor.apply()

                nameTextView.text = name
                phoneTextView.text = phone
            }
            .setNegativeButton("◀️") { _, _ ->
                // Cancel button clicked
            }
            .show()
            .apply {
                // Find the TextViews inside the dialog
                val nameTextView = findViewById<TextView>(R.id.user_name)
                val phoneTextView = findViewById<TextView>(R.id.user_number)

                // Set the values from the EditTexts to the TextViews
                if (nameTextView != null && phoneTextView != null) {
                    nameTextView.text = dialogNameEditText.text.toString()
                    phoneTextView.text = dialogPhoneEditText.text.toString()
                }

                // Save the values to SharedPreferences
                val name = dialogNameEditText.text.toString()
                val phone = dialogPhoneEditText.text.toString()
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("phone", phone)
                editor.apply()
            }
    }

    private fun repleceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true

        }

//        Tillar, Talim, Clinika
        when (item.itemId) {
            R.id.language -> {
                showChangeLang()
            }

            R.id.tizim -> {
                showDeveloperinfo()
//                startActivity(Intent(this@MainActivity,TalimFragment::class.java))
//                finish()
            }

            R.id.clinica -> {
                showDeveloperinfo()
            }

        }

////        Fanlar
//        when(item.itemId){
//
//            R.id.osteologiya->{ showDeveloperinfo() }
//            R.id.miologiya -> { showDeveloperinfo() }
//            R.id.splanchnologia -> { showDeveloperinfo() }
//            R.id.nevrologiya -> { showDeveloperinfo() }
//            R.id.angioloyiga -> { showDeveloperinfo() }
//
//        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_language, menu)
        return true
    }

    private fun showChangeLang() {
        val listItems = arrayOf("English", "Uzbek", "Russ")
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Languages; Tillar; Языки")
        builder.setSingleChoiceItems(listItems, -1) { dialog, which ->

            if (which == 0) {
                setLocate("en")
                recreate()

            } else if (which == 1) {
                setLocate("uz")
                recreate()

            } else if (which == 2) {
                setLocate("ru")
                recreate()

            }
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()

    }

    private fun setLocate(s: String) {
        val locale = Locale(s)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", s)
        editor.apply()

    }

    private fun loadLocale() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        setLocate(language.toString())

    }


}
