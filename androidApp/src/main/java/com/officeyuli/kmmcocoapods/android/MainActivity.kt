package com.officeyuli.kmmcocoapods.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.officeyuli.kmmcocoapods.Greeting
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.officeyuli.kmmcocoapods.android.view.CafeAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var cafeRecyclerView : RecyclerView
    private lateinit var  viewModel : MainViewModel
    private val adapter : CafeAdapter by lazy { CafeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cafeRecyclerView = findViewById(R.id.rv_cafeList)
        cafeRecyclerView.adapter = adapter
        cafeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cafeRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.fetchCafeData("taipei")
        viewModel.cafeListLiveData.observe(this, Observer {
            adapter.cafeList = it
            adapter.notifyDataSetChanged()
        })
    }
}

