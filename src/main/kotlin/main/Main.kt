package main

import zipf.Song
import zipf.bestNSongs

fun main(args: Array<String>) {
    System.out.println("Hello project")
    bestNSongs(3, arrayOf(
            Song(197812, "re_hash"),
            Song(78906, "5_4"),
            Song(189518, "tomorrow_comes_today"),
            Song(39453, "new_genious"),
            Song(210492, "clint_eastwood"),
            Song(26302, "man_research"),
            Song(22544, "punk"),
            Song(19727, "sound_check"),
            Song(17535, "double_bass"),
            Song(18782, "rock_the_house"),
            Song(198189, "19_2000"),
            Song(13151, "latin_simone"),
            Song(12139, "starshine"),
            Song(11272, "slow_country"),
            Song( 10521, "m1_a1"))).forEach { System.out.println(it) }
}
