package impl.zipf

import java.util.PriorityQueue

internal object Zipf {
	fun bestNSongs(amountOfSongsToReturn: Int, songs: Array<Song>): Array<String> {
		val queue = PriorityQueue<Song>(amountOfSongsToReturn)
		songs.forEachIndexed { index, (value, name) ->
			val realValueSong = Song(value * (index + 1), name)
			// If I have enough songs, compare the least valuable one and this one. If this one is more valuable, remove the least valuable one and add this one
			// If I don't have enough songs, just add this one
			if (queue.size == amountOfSongsToReturn) {
				if (realValueSong > queue.peek()) {
					queue.remove()
					queue.add(realValueSong)
				}
			} else {
				queue.add(realValueSong)
			}
		}
		return queue.map { it.toString() }.toTypedArray()
	}
}
