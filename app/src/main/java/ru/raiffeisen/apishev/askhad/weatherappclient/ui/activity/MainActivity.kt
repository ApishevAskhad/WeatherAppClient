package ru.raiffeisen.apishev.askhad.weatherappclient.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.runBlocking
import ru.raiffeisen.apishev.askhad.weatherappclient.R
import ru.raiffeisen.apishev.askhad.weatherappclient.network.WeatherApi
import ru.raiffeisen.apishev.askhad.weatherappclient.ui.fragment.FormFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FormFragment())
            .commit()
    }
}
