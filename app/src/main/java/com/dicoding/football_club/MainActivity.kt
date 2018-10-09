package com.dicoding.football_club

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import com.dicoding.football_club.R.attr.layoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        mainActivityUI()
        initData()

        }

    private fun initData() {
        val name =  resources.getStringArray(R.array.footbal_name)
        val desc =  resources.getStringArray(R.array.footbal_description)
        val image = resources.obtainTypedArray(R.array.football_image)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i,0) , desc[i]))
        }

        image.recycle()
    }

    private fun intentFootball(item: Item){
        startActivity(intentFor<DetailFootballActivity>("bundle_football" to item))
    }

    fun mainActivityUI() {

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                clipToPadding = false
                backgroundColor = Color.WHITE
                setPadding(dip(16), dip(16), dip(16), 0)
                layoutManager = LinearLayoutManager(context)
                adapter = FootballAdapter(context , items, {item: Item -> intentFootball(item)})

//                            "name" to it.name , "image" to it.image , "description" to it.description)

//                    val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
//                    toast.show()

                }
            }
        }
    }
