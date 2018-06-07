package com.example.clemence.thelappremnant

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.clemence.thelappremnant.model.Leader
import kotlinx.android.synthetic.main.activity_detail_leader2.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailLeader : AppCompatActivity() {


    companion object {
        private const val LEADER_EXTRA = "LEADER_EXTRA"
        fun createIntent(context: Context, leader: Leader?): Intent {
            return Intent(context, DetailLeader::class.java)
                    .putExtra(LEADER_EXTRA, leader)




        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_leader2)

        val leader = intent.getParcelableExtra<Leader>(LEADER_EXTRA)

        //Afficher du name de la ligne dans l'AppBar
        title = leader.name

        LeaderNameD.text = leader.name
        bioTextView.text = leader.bio
        statTextView.text = leader.stat

        Glide.with(cell_imageView_leader).load(leader.image)
                .into(cell_imageView_leader)
    }

}
