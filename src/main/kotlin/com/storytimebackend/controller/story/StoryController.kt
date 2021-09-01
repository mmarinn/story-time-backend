package com.storytimebackend.controller.story

import com.storytimebackend.entities.Story
import com.storytimebackend.usecases.story.ChangeStory
import com.storytimebackend.usecases.story.RetrieveStory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Controller
class StoryController {

    @Autowired
    private lateinit var retrieveStory: RetrieveStory;

    @Autowired
    private lateinit var changeStory: ChangeStory

    @GetMapping
    fun retrieveStory(@RequestParam idStory : Long): ResponseEntity<Story> {
        val optionalStory = retrieveStory.retrieveStory(idStory)
        if(optionalStory.isEmpty) {
            return ResponseEntity(NOT_FOUND)
        }

        return ResponseEntity(optionalStory.get(), OK)
    }

    @PostMapping
    fun changeStory(@RequestBody story:Story) : ResponseEntity<HttpStatus>{
        changeStory.changeStory(story)
        return ResponseEntity(OK)
    }

}