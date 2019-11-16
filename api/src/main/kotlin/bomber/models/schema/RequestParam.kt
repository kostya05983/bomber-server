package bomber.models.schema

data class RequestParam(
    val name: String,
    val isGeneratorNeed: Boolean,
    val value: String?,
    val generator: String?,
    val config: GeneratorConfig?
)