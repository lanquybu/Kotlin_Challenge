class School {
    var db = mutableMapOf<Int, MutableList<String>>()
    fun add(student: String, grade: Int) {
        val names = 
            db.getOrElse(grade) { mutableListOf<String>() }
        names.add(student)
        db.set(grade, names)
        db[grade]!!.sort()
    }    
    fun grade(grade: Int): List<String> = 
        db.getOrElse(grade) { listOf<String>().sorted() }
    fun roster(): List<String> =
        db.toSortedMap().values.flatMap { it.sorted() }
}