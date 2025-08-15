class Deque<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    fun push(value: T) {
        if (first == null) {
            first = Node(value)
        } else {
            if (last == null) {
                last = first
            }
            first = Node(value, right = first)
            first?.right?.left = first
        }
    }
    fun pop(): T? {
        val toReturn = first?.value
        first?.right?.let {
            first = first!!.right
            first?.left = null
            if (first == last) {
                last = null
            }
        } ?: run { first = null }
        return toReturn
    }
    fun unshift(value: T) {
        if (first == null)
            push(value)
        else if (last == null) {
            last = Node(value, left = first)
            first?.right = last
        } else {
            val add = Node(value, left = last)
            last?.right = add
            last = add
        }
    }
    fun shift(): T? {
        if (last == null) {
            val ret = first?.value
            first = null
            return ret
        } else {
            val ret = last?.value
            last?.left?.right = null
            if (last?.left == first)
                last = null
            else
                last = last?.left
            return ret
        }
    }
}
class Node<T>(var value: T, var left: Node<T>? = null, var right: Node<T>? = null)
