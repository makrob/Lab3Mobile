package com.example.lab3mobile

import android.os.Bundle
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3mobile.model.Tip

class TipDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_detail)

        val tip = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("TIP", Tip::class.java) as? Tip
        } else {
            @Suppress("DEPRECATED")
            intent.getSerializableExtra("TIP") as? Tip
        }

        if (tip != null) {
            setupUI(tip)
        }

        findViewById<Button>(R.id.btnClose).setOnClickListener {
            finish()
        }
    }

    private fun setupUI(tip: Tip) {
        findViewById<TextView>(R.id.tvDetailTitle).text = tip.title
        findViewById<TextView>(R.id.tvDetailDescription).text = tip.description
        findViewById<ImageView>(R.id.ivDetailImage).setImageResource(tip.imageResId)
        findViewById<TextView>(R.id.tvDetailDay).text = "День ${tip.day}"
    }
}