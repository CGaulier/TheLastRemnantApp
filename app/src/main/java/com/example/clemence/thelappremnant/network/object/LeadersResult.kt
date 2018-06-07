package com.example.clemence.thelappremnant.network.`object`

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class LeadersResult {


        lateinit var leaders: ArrayList<JsonLeader>
    }

