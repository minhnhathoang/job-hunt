package com.nhathm.jobhunt.data.model

data class Job(
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val type: String? = null,
    val address: Address? = null,
    val company: Company? = null,
    val position: List<Position>? = null,
    val skills: List<Skill>? = null,
    val salary: Salary? = null,
    val create_at: String? = null
)