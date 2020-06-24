package com.advancedprogramming2.flightmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servers)

        Handler().postDelayed({
            startActivity(Intent(this,ServerActivity::class.java))
            finish()
        },2000)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        configureEvents()
//        initControls()
//
//    }
//
//    fun configureEvents(){
//        /*Configure Event item server click*/
//        val listView: ListView = findViewById(R.id.listview_1)
//        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
//
//            override fun onItemClick(parent: AdapterView<*>, view: View,
//                                     position: Int, id: Long) {
//
//                // value of item that is clicked
//                val itemValue = listView.getItemAtPosition(position) as String
//                val editText: EditText = findViewById(R.id.txt_url)
//                editText.setText(itemValue)
//                editText.visibility = View.VISIBLE
//            }
//
//        }
//        /*End Configure Event item server click*/
//        /*Configure Event button Try URL*/
//        val btnTryUrl: Button = findViewById(R.id.btn_try_url)
//        btnTryUrl.setOnClickListener {
//            val editText:EditText = findViewById(R.id.txt_url)
//            editText.setText("")
//            editText.visibility = View.VISIBLE
//        }
//        /*Configure Event button Try URL*/
//        /*Configure Event button Connect*/
//        val btnConnect: Button = findViewById(R.id.btn_connect)
//        btnConnect.setOnClickListener {
//            val editText:EditText = findViewById(R.id.txt_url)
//            //FlightMobileDatabase.get(application).getServerDao().addServer(ServerEntity(1, editText.text.toString()))
//            //database.serverDao().addServer(ServerEntity(1, editText.text.toString()))
//        }
//        /*Configure Event button Try URL*/
//
//    }
//
//    fun initControls(){
//        // Initialized list of servers
//        var servers = FlightMobileDatabase.get(application).getServerDao().getAllServers()
//
//
//
////        val array: ArrayList<String> = arrayListOf<String>()
////
////        for(server in servers) array.add(server.url)
////
////        val adapter = ArrayAdapter(this,
////            R.layout.listview_item, array)
////        val listView: ListView = findViewById(R.id.listview_1)
////        listView.adapter = adapter
//        /*End Initialized list of servers*/
//    }

}