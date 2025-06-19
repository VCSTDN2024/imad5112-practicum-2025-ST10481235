package vcmsa.ci.musicmanager

class Processor (
    title:MutableList<String>,
    songspin:MutableList<String>,
    artist:MutableList<String>,
    artistSpin:MutableList<String>,
    ratingText:MutableList<String>,
    ratingSpin:MutableList<Int>

) {
    fun getAverageRating (): Double {
        if (SongPlaylist.ratingSpin.isEmpty()) return 0.0
        return SongPlaylist.ratingSpin.sum().toDouble() / SongPlaylist.ratingSpin.size
    }

}
