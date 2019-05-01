package permutations

internal object Permutations {
    fun of(target: String) = when (target.length) {
        0 -> emptyList()
        1 -> listOf(target)
        else -> permutations(target)
    }

    private fun permutations(subject: String, next: Char? = null): List<String> =
            if (next != null) {
                when (subject.length) {
                    1 -> listOf(next + subject, subject + next)
                    else -> permutations(subject.substring(0, subject.length - 1), subject[subject.length - 1])
                            .flatMap { appendAtEachIndex(it, next) }
                }
            } else {
                when (subject.length) {
                    1 -> listOf(subject)
                    else -> permutations(subject.substring(0, subject.length - 1), subject[subject.length - 1])
                }
            }

    private fun appendAtEachIndex(subject: String, pivot: Char) = (0 until subject.length + 1).map {
            subject.substring(0 until it) +
                    pivot +
                    subject.substring(it until subject.length)
    }
}
