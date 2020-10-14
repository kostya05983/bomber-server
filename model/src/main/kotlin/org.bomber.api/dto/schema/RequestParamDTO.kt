package org.bomber.api.dto.schema

data class RequestParamDTO(
    val name: String,
    val isGeneratorNeed: Boolean,
    val value: String?,
    val generator: String?,
    val config: GeneratorConfigDTO?
)