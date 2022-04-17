package com.example.nasa

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa.Response.Nasamainresponse
import com.example.nasa.Response.NasamainresponseItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),Recyclerview_list.OnItemClickListener {
   private val arrayList_response = ArrayList<NasamainresponseItem>()
    private  var listAdapter: Recyclerview_list?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcv_list.layoutManager = LinearLayoutManager(this)
        if (supportActionBar != null) supportActionBar?.hide()
        call_splash_Screen()
        if (!check_db_network_first()) {
            no_data_tv.visibility = View.VISIBLE
        } else {
            api_call()
        }
    }

    private fun getDatabase_db() {

    }


    private fun api_call() {

        val nasaApi = RetrofitInstance.getInstance().create(NasaApi::class.java)
        GlobalScope.launch {
            val result = nasaApi.setRequest()
            Log.d("test1: ", result.body().toString())
            if (result.body() != null) {
                for (i in 0 until result.body()!!.size) {
                    arrayList_response.add(result.body()!![i])
                }
            }
        }
        Handler(Looper.getMainLooper()).postDelayed({
            initalize_Rcv()
        }, 4000)// sometimes response taking more than 4 sec

    }

    fun initalize_Rcv() {
        if (arrayList_response.size > 0) {
            listAdapter = Recyclerview_list(arrayList_response, this,this)
            rcv_list.adapter = listAdapter
            listAdapter!!.notifyDataSetChanged()
        } else
            no_data_tv.visibility = View.VISIBLE
    }

    private fun check_db_network_first(): Boolean {
        val connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetwork != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }

    private fun call_splash_Screen() {
        val intent = Intent(this, Splashscreen::class.java)
        startActivity(intent)
    }

    override fun onItemClick(bundle : Bundle) {

        val intent = Intent(this, DetailsPage::class.java)
        val extras = Bundle()
        extras.putString("hdurl", bundle.getString("hdurl"))
        extras.putString("desc", bundle.getString("desc"))
        extras.putString("date", bundle.getString("date"))
        extras.putString("title", bundle.getString("title"))
        intent.putExtras(extras)
        startActivity(intent)
    }

}