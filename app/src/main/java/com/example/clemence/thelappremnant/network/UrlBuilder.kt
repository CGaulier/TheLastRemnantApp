package com.example.clemence.thelappremnant.network

class UrlBuilder {
    companion object {

        private fun baseUrl(): String {
            val isProduction = true

            if (isProduction) {
                return "http://tazertazer.com/api"
            } else {
                return "http://dev.tazertazer.com/api"
            }
        }

        fun leaders(): String {
            return "${baseUrl()}/TheLastRemnantCharacters.json"
        }
    }
}