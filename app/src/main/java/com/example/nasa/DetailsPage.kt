package com.example.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details_page.*

class DetailsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)
        if (supportActionBar != null) supportActionBar?.hide()
        main_header_tv.setOnClickListener { finish() }
        intent.getStringExtra("title")?.let { details_title_tv.text = it}
        intent.getStringExtra("desc")?.let { details_desc_tv.text = it}
        intent.getStringExtra("date")?.let { details_date_tv.text = it}
        intent.getStringExtra("hdurl")?.let { Glide.with(this).load(it)
            .into(img_iv)}
    }

}