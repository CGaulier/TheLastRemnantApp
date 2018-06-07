package com.example.clemence.thelappremnant.item

import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.clemence.thelappremnant.R

import com.example.clemence.thelappremnant.model.Leader
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.activity_detail_leader2.*
import kotlinx.android.synthetic.main.activity_main.*

class LeaderItem(val leader:Leader): AbstractItem<LeaderItem, LeaderItem.LeaderViewHolder>()  {


        override fun getType():Int {
            //Tjrs virer les TODO
            return R.id.LeaderNameD
        }

        override fun getViewHolder(v: View?): LeaderViewHolder {
            //v=layout chargé à partir de la méthode getLayoutRes
            //v =  layout chargé à partir de res/layout/cell_metro.xml
            return LeaderViewHolder(v)
        }

        override fun getLayoutRes(): Int {
            // retourne la reference du layout de la cellule à charger
            return R.layout.cell_leader
        }

        //sera crée environ 10 MetroViewHolder (car recyclé)
        class LeaderViewHolder : FastAdapter.ViewHolder<LeaderItem>{


            var leaderNameTextView: TextView? = null
            var leaderBioTextView: TextView? = null
            var leaderStatTextView: TextView? = null
            //var leaderImageTextView: TextView? = null
            var containerCellLeader: ConstraintLayout?=null

            //ItemView = vue chargée à partir de res/layout/cell_metro.xml
            constructor(itemView: View?): super(itemView){
                //le super , quand on appelle le constructeur d'une class, super permet d'appeller auto la methode de class parente
                // On va récupérer les composants de notre cellule

                leaderNameTextView = itemView?.findViewById(R.id.LeaderNameD)

                leaderBioTextView = itemView?.findViewById(R.id.bioTextView)

                leaderStatTextView = itemView?.findViewById(R.id.statTextView)

                //leaderImageTextView = itemView?.findViewById(R.id.cell_imageView_leader)


                containerCellLeader = itemView?.findViewById(R.id.containerCellLeader)
            }


            //recyclage -> nettoyage de la cellule, avant une ré-utilisation future
            override fun unbindView(item: LeaderItem?) {

                leaderNameTextView?.text = null
                leaderBioTextView?.text = null
                leaderStatTextView?.text = null
                //leaderImageTextView?.text = null




            }

            // refresh UI: la cellule va être affichée.
            //Au boulot: faut que ça brille ! On est beaux et frais
            override fun bindView(item: LeaderItem?, payloads: MutableList<Any>?) {

                val leader = item?.leader

                if(leader is Leader){

                    leaderNameTextView?.text = leader.name
                    leaderBioTextView?.text = leader.bio
                    leaderStatTextView?.text = leader.stat

                    //leaderImageTextView?.text = leader.image







                    /*//On applique la couleur sur le fond
                    containerCellMetro?.setBackgroundColor(metro.color)
                    metroNameTextView?.text = metro.name
                    metroDestinationsTextView?.text = metro.directions
                    */

                }
            }

        }
    }
