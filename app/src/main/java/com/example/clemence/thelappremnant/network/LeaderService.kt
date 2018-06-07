package com.example.clemence.thelappremnant.network

import android.widget.ThemedSpinnerAdapter
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.clemence.thelappremnant.TheLastRemnantApp
import com.example.clemence.thelappremnant.network.`object`.JsonLeader
import com.example.clemence.thelappremnant.network.`object`.JsonRoot
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest

class LeaderService {
    companion object {
        fun retrieveLeaders(metrosSuccess:(List<JsonLeader>)-> Unit, leadersFailure: (error: VolleyError?)->Unit ){// La requete

            val url = UrlBuilder.leaders()
            val request = BaseRequest.Builder<JsonRoot>(Request.Method.GET,
                    url, JsonRoot::class.java)
                    .listener(object: RequestListener<JsonRoot> {// lancement du callback
                    override fun onSuccess(request: Request<*>?,
                                           response: NetworkResponse?,
                                           result: JsonRoot?) {

                        var leadersList = result?.result?.leaders


                        metrosSuccess(leadersList ?: emptyList<JsonLeader>())

                    }

                        override fun onFailure(request: Request<*>?,
                                               response: NetworkResponse?,
                                               error: VolleyError?) {

                            leadersFailure(error)
                        }

                    }).build()//on construit l'object requete
            //envoyer la requete grace à la queue pour gerer un par 1
            TheLastRemnantApp.queue.add(request)

        }
    }
}