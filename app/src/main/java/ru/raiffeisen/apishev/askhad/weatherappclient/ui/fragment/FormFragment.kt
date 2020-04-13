package ru.raiffeisen.apishev.askhad.weatherappclient.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_form.*
import kotlinx.coroutines.runBlocking
import ru.raiffeisen.apishev.askhad.weatherappclient.R
import ru.raiffeisen.apishev.askhad.weatherappclient.network.WeatherApi

class FormFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_add.setOnClickListener {
            val cityName = ed_city.text.toString()
            val service = WeatherApi.create()
            runBlocking {
                val response = service.getTemp(cityName)
                tv_temp.text = response.temp.toString()
            }
        }
    }

}