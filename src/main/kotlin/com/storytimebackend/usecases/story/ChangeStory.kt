package com.storytimebackend.usecases.story

import com.storytimebackend.drivers.database.StoryRepository
import com.storytimebackend.entities.Story
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ChangeStory {
    @Autowired
    private lateinit var storyRepository: StoryRepository

    fun changeStory(story: Story) {
        storyRepository.save(story)
    }

}