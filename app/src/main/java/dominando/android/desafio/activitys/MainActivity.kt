package dominando.android.desafio.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import dominando.android.desafio.R

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var fm: FragmentManager
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false)


//        fm = supportFragmentManager
//        fm.beginTransaction().add(R.id.fragmentContainerMain, RestaurantesFragment(), null)
//            .addToBackStack(null).commit()
    }
}

