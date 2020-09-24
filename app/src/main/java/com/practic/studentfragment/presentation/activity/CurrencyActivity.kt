package com.practic.studentfragment.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.practic.studentfragment.R
import com.practic.studentfragment.data.api.ApiConnection
import com.practic.studentfragment.domain.CurrencyObject
import kotlinx.android.synthetic.main.activity_currency.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList


class CurrencyActivity : AppCompatActivity() {

    val currencys: ArrayList<String> = arrayListOf(
        "CAD",
        "HKD",
        "ISK",
        "PHP",
        "DKK",
        "HUF",
        "CZK",
        "AUD",
        "RON",
        "SEK",
        "IDR",
        "INR",
        "BRL",
        "RUB",
        "HRK",
        "JPY",
        "THB",
        "CHF",
        "SGD",
        "PLN",
        "BGN",
        "TRY",
        "CNY",
        "NOK",
        "NZD",
        "ZAR",
        "USD",
        "MXN",
        "ILS",
        "GBP",
        "KRW",
        "MYR"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencys)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_activity_currency_select.adapter = adapter
        spinner_activity_currency_select.prompt = "Currency conversion"

        spinner_activity_currency_select.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?,
                position: Int, id: Long
            ) {
                Toast.makeText(baseContext, "Position = $position", Toast.LENGTH_SHORT).show()
                initiateRequest(currencys[position])
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }


    }

    fun initiateRequest(currency: String){
//        var apiConnection = ApiConnection()
//        apiConnection.initializeAPIObject().initiateGetСurrency(currency).enqueue(object :
//            Callback<CurrencyObject> {
//            override fun onFailure(call: Call<CurrencyObject>, t: Throwable) {
//                Log.d("Failure", "fail")
//            }
//
//            override fun onResponse(
//                call: Call<CurrencyObject>,
//                response: Response<CurrencyObject>
//            ) {
//                var currencyObject = response.body()
//                textview_activity_currency_text.text = currencyObject.toString()
//                Log.d("Success", currencyObject.toString())
//            }
//        })
    }


}