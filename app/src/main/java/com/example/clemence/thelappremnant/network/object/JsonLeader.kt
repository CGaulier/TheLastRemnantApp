package com.example.clemence.thelappremnant.network.`object`

import android.content.Context
import android.support.v4.content.ContextCompat
import com.example.clemence.thelappremnant.model.Leader

class JsonLeader {
    lateinit var name: String
    lateinit var bio: String
    lateinit var stat: String
    lateinit var image: String
    lateinit var id:String

}
//Extension avec une fonction pour etendre la class de base
fun JsonLeader.toLeader(context: Context): Leader {

    return Leader(this.name, this.bio, this.stat, this.image, this.id)
            //ContextCompat.getColor(context, android.R.color.white))
}