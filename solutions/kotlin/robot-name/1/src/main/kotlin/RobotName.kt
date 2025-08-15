class Robot {
    companion object {
        val letterRange = 'A'..'Z'
        val numberRange = '0'..'9'
        val useNames = mutableSetOf<String>()
    }
    var name: String = generateNewName()
    fun reset() {
        this.name = generateNewName()
    }
    private fun generateNewName(): String {
        val name = randomName()
        return if (useNames.contains(name)) generateNewName()
        else {
            useNames.add(name)
            return name
        }
    }
    private fun randomName(): String = StringBuilder()
            .append(letterRange.random())
            .append(letterRange.random())
            .append(numberRange.random())
            .append(numberRange.random())
            .append(numberRange.random())
            .toString()
}