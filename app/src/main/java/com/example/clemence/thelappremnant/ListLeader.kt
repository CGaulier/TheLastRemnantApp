package com.example.clemence.thelappremnant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.example.clemence.thelappremnant.item.LeaderItem
import com.example.clemence.thelappremnant.model.Leader
import com.example.clemence.thelappremnant.network.LeaderService
import com.example.clemence.thelappremnant.network.`object`.JsonLeader
import com.example.clemence.thelappremnant.network.`object`.toLeader
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import kotlinx.android.synthetic.main.activity_list_leader2.*
import kotlinx.android.synthetic.main.cell_leader.*

class ListLeader : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_leader2)





        val linearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
        leaderRecyclerView.layoutManager = linearLayoutManager

        val itemAdapter = FastItemAdapter<LeaderItem>()

        /*for (metro in metros) {
            //metro _ > MetroItem

            //Un item =  cellule (rattachée plus tard à une cellule graphique -> VH)
            val item =  MetroItem(metro)
            itemAdapter.add(item)*/

        LeaderService.retrieveLeaders({ leaders: List<JsonLeader> ->
            //Ici on a reçu la liste des metros
            for(leadersJson in leaders) {
                //un item =  cellule (rattachée plus tard a une celulle
                val item = LeaderItem(leadersJson.toLeader(this))






                itemAdapter.add(item)


            }

        },
                {

                })

        leaderRecyclerView.adapter = itemAdapter

        itemAdapter.withOnClickListener(object : OnClickListener<LeaderItem> {
            override fun onClick(v: View?, adapter: IAdapter<LeaderItem>?, item: LeaderItem?, position: Int): Boolean {

                //val intent = Intent(this@UndergroundActivity, DetailMetroActivity::class.java)
                val leader = item?.leader
                val intent = DetailLeader.createIntent(this@ListLeader, leader)
                startActivity(intent)

                return true
            }

        })



    }

}

