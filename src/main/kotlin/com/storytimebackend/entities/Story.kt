package com.storytimebackend.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "Story")
data class Story(
    @Id
    private val idStory: Long,

    @Column
    private val text: String,

    @Column
    private val modifiedBy: String,
)
