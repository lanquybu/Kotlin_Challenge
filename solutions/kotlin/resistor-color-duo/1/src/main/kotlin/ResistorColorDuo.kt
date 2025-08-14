object ResistorColorDuo {
    fun value(vararg colors: Color): Int =
        colors.take(2).fold(0, {acc, color ->  acc*10+color.ordinal})
}
