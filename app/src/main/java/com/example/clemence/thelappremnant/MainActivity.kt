package com.example.clemence.thelappremnant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Glide.with(accPics).load("http://jrpg.moe/wp-content/uploads/2015/12/LastRemnant-e1450070306752.jpg")
                .into(accPics)



    //click
        buttonAcc.setOnClickListener{

            val intent = Intent(this, ListLeader::class.java )

            // on demande a android de demarer l'activité
            startActivity(intent)

            //finish() //tuer l'activité
        }




    }
}
