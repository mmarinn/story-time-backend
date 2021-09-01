package com.storytimebackend.usecases.story

import com.storytimebackend.drivers.database.StoryRepository
import com.storytimebackend.entities.Story
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class RetrieveStory {

    @Autowired
    private lateinit var storyRepository: StoryRepository;

    fun retrieveStory(id: Long): Optional<Story> {

        return storyRepository.findById(id)
    }

}