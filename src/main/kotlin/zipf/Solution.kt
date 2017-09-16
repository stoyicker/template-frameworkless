package zipf

import java.util.*

internal fun bestNSongs(amountOfSongsToReturn: Int, songs: Array<Song>): Array<String> {
    val queue = PriorityQueue<Song>(amountOfSongsToReturn)
    songs.forEachIndexed { index, (value, name) ->
        val realValueSong = Song(value * (index + 1), name)
        if (queue.size == amountOfSongsToReturn) {
            if (realValueSong > queue.peek()) {
                queue.remove()
                queue.add(realValueSong)
            }
        } else {
            queue.add(realValueSong)
        }
    }
    return queue.reversed().map { it.name }.toTypedArray()
}
