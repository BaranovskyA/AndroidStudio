package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.City
import com.example.education.domain.usecase.function.sort.CurrencyObject
import com.example.education.domain.usecase.function.sort.RequestCurrencyUseCase
import com.example.education.presentation.adapter.CityAdapter
import io.fabric.sdk.android.services.concurrency.AsyncTask
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.fragment_cities.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class CityFragment : BaseFragment() {
    var cities: ArrayList<City> = ArrayList()
    var adapter : CityAdapter? = null

    lateinit var currencyUseCase: RequestCurrencyUseCase

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_cities, container, false)
        currencyUseCase = RequestCurrencyUseCase()
        currencyUseCase.execute(CurrencyObserver())
        val obj = currencyUseCase.createObservableObject()

        obj.map {
            val a: String = it.weather[0].description
            Log.d("CITY FRAGMENT", it.toString())
        }
        currencyUseCase.dispose()
        return rootView
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()

        initializeOnClickListener()

        //someTask().execute()
    }

    override fun onStop() {
        super.onStop()
        currencyUseCase.clear()
    }

    class CurrencyObserver : DisposableObserver<CurrencyObject>(){
        override fun onComplete() {}

        override fun onNext(t: CurrencyObject) {
            Log.d("HERE", t.toString())
        }

        override fun onError(e: Throwable) {}

    }

    class someTask() : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            val client = OkHttpClient()

            val request: Request = Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=London&appid=2d9cfba3368d9069cdf80846151df67c")
                .get()
                .build()

            val response: Response = client.newCall(request).execute()

            if(response.isSuccessful) run {
                
            }

            return response.toString()
        }

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }


    fun initializeOnClickListener() {
        button_fragment_cities_add_location.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.onOk = {
                addCity("Brazilia, br")
            }
            activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "Custom") }
        }
    }

    fun addCity(fromDialog: String) {
        val arguments = fromDialog.split(',')
        cities.add( City(arguments[0], arguments[1]))
        updateAdapter()
    }

    fun sortCitiesByName() {

        updateAdapter()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = CityAdapter(cities)
    }

    fun initializeData(): ArrayList<City> {
        if(cities.size == 0) {
            cities.add( City("London", "uk"))
        }
        return cities
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_cities?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_cities?.adapter = adapter
    }

}