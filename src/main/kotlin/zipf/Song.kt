package zipf

internal data class Song(val value: Int, val name: String) : Comparable<Song> {
    override fun compareTo(other: Song) = value.compareTo(other.value)
}