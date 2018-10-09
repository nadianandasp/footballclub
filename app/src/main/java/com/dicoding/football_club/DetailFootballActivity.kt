package com.dicoding.football_club

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_football.*
import kotlinx.android.synthetic.main.item_main.*

class DetailFootballActivity : AppCompatActivity() {

    private lateinit var sport: Item


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)

        sport = intent.getParcelableExtra("bundle_football")


       // image = resources.getDrawable(image)


        tv_football_detail.text = sport.name
        Glide.with(this).load(sport.image).into(img_football_detai)
        tv_description_detail.text = sport.description
    }
}
