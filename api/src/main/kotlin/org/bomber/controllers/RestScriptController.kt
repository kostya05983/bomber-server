package org.bomber.controllers

import org.bomber.api.dto.requests.CreateScriptRequest
import org.bomber.api.dto.requests.UpdateScriptRequest
import org.bomber.api.dto.script.RestScriptDTO
import org.bomber.api.dto.script.RestScriptItemsDTO
import org.bomber.service.rest.script.RestScriptService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author Konstantin Volivach
 */
@RestController
@RequestMapping(
    value = ["/bomber/bomber-api/script/v1"]
)
class RestScriptController(
    private val scriptService: RestScriptService
) {
    @PostMapping
    suspend fun createScript(@RequestBody request: CreateScriptRequest): ResponseEntity<RestScriptDTO> {
        val script = scriptService.createScript(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(script)
    }

    @PutMapping("/{id}")
    suspend fun updateScript(
        @PathVariable id: String,
        @RequestBody updateRequest: UpdateScriptRequest
    ): ResponseEntity<RestScriptDTO> {
        val script = scriptService.updateScript(updateRequest)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping(value = ["/{id}"])
    suspend fun getScript(@PathVariable id: String): ResponseEntity<RestScriptDTO> {
        val script = scriptService.getScript(id)
        return ResponseEntity.status(HttpStatus.OK).body(script)
    }

    @GetMapping
    suspend fun getScriptAll(
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): ResponseEntity<RestScriptItemsDTO> {
        val scriptItems = scriptService.getScriptAll(offset, limit)
        return ResponseEntity.status(HttpStatus.OK).body(scriptItems)
    }

    @DeleteMapping(value = ["/{id}"])
    suspend fun deleteScript(@PathVariable id: String): ResponseEntity<RestScriptDTO> {
        val deleted = scriptService.deleteScript(id)
        return ResponseEntity.status(HttpStatus.OK).body(deleted)
    }
}