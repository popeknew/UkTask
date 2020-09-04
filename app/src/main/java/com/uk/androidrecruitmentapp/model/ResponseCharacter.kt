package com.uk.androidrecruitmentapp.model

data class ResponseCharacter(
        val info: ResponseInfo,
        val results: List<Character>
)

data class Planet(
        val name: String,
        val url: String
)

data class Character(
        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        val origin: Planet,
        val location: Planet,
        val image: String,
        val episode: List<String>,
        val url: String
)