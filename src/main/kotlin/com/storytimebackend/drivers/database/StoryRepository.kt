package com.storytimebackend.drivers.database

import com.storytimebackend.entities.Story
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoryRepository : JpaRepository<Story, Long> {
}