package io.github.chespinoza.rest

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


interface TodoRepository: JpaRepository<Todo, Long>

@RestController @RequestMapping(value = ["/todo"]) @EnableWebMvc
class TodoResource(val todoRepo: TodoRepository) {
    @GetMapping(value = ["/"])
    fun getAll() = todoRepo.findAll()
}

@Entity
class Todo(@Id @GeneratedValue(strategy = GenerationType.AUTO)
        val Id: Long = 0, var text: String = "", var done: Boolean = false, val createdAt: Instant = Instant.now())