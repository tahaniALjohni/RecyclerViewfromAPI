package com.example.recyclerviewfromapi

class Person : ArrayList<Person.personDetails>(){
    data class personDetails(
        val name: String
    )
}