package org.bomber.api.dto.script

data class RestPipelineConfigurationDTO(
    val replay: Long,
    val replayAfterFailed: Boolean,
    val replayAfterTimeout: Long
)