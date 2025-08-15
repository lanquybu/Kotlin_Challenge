object BeerSong {
  fun verses(startBottles: Int, takeDown: Int): String =
    (takeDown..startBottles).reversed().map { bottle ->
      verse(bottle)
    }.joinToString("\n")
  private fun verse(num: Int) = when {
    (num == 0) -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    (num == 1) -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    else -> "${bottleForm(num)} of beer on the wall, ${bottleForm(num)} of beer.\nTake one down and pass it around, ${bottleForm(num - 1)} of beer on the wall.\n"
  }
  private fun bottleForm(value: Int) = if(value == 1) { "1 bottle"} else { "$value bottles"}
}