package com.example.lab3mobile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.adapter.TipAdapter
import com.example.lab3mobile.data.TipsData
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: MaterialToolbar
    private var currentLayoutManager = TipAdapter.LAYOUT_MANAGER_VERTICAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        val tips = TipsData.getTips()
        val adapter = TipAdapter(tips, currentLayoutManager)

        when (currentLayoutManager) {
            TipAdapter.LAYOUT_MANAGER_VERTICAL -> {
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            TipAdapter.LAYOUT_MANAGER_HORIZONTAL -> {
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            }
            TipAdapter.LAYOUT_MANAGER_GRID -> {
                recyclerView.layoutManager = GridLayoutManager(this, 2)
            }
        }

        recyclerView.adapter = adapter
    }
}