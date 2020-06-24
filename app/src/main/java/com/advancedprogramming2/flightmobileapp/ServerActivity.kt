package com.advancedprogramming2.flightmobileapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_servers.*

class ServerActivity : AppCompatActivity() {

    private lateinit var viewModel: ServerActivityViewModel
    private lateinit var adapter: ServerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servers)
        configureViewModel()
        configureEvents()
    }


        fun configureEvents(){
        /*Configure Event item server click*/
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
        /*End Configure Event item server click*/
        /*Configure Event button Try URL*/
        val btnTryUrl: Button = findViewById(R.id.btn_try_url)
        btnTryUrl.setOnClickListener {
            val editText: EditText = findViewById(R.id.txt_url)
            editText.setText("")
            editText.visibility = View.VISIBLE
        }
        /*Configure Event button Try URL*/
        /*Configure Event button Connect*/
        val btnConnect: Button = findViewById(R.id.btn_connect)
        btnConnect.setOnClickListener {
            val editText:EditText = findViewById(R.id.txt_url)
            viewModel.addServerEntity(ServerEntity(editText.text.toString(),null))
        }
        /*Configure Event button Try URL*/

    }

    fun configureViewModel() {

        viewModel = ViewModelProvider(this).get(ServerActivityViewModel::class.java)
        viewModel.populateServersList()
        viewModel.serverEntityList.observe(this, Observer {
            adapter.setLocationList(it)
        })
        viewModel.currentURL.observe(this, Observer {
            adapter.setURLSelected(it)
            txt_url.setText(it)
        })
        adapter = ServerAdapter(this)
        rv_servers.adapter = adapter

    }

}