class EmptyBufferException : Exception("Buffer is empty")
class BufferFullException : Exception("Buffer is full")
class CircularBuffer<T>(private val capacity: Int) {
    private val buffer: Array<Any?> = arrayOfNulls(capacity)
    private var readIndex = 0
    private var writeIndex = 0
    private var size = 0
    fun write(element: T) {
        if (isFull()) {
            throw BufferFullException()
        }
        buffer[writeIndex] = element
        writeIndex = (writeIndex + 1) % capacity
        size++
    }
    fun read(): T {
        if (isEmpty()) {
            throw EmptyBufferException()
        }
        @Suppress("UNCHECKED_CAST")
        val element = buffer[readIndex] as T
        buffer[readIndex] = null
        readIndex = (readIndex + 1) % capacity
        size--
        return element
    }
    fun clear() {
        buffer.fill(null)
        readIndex = 0
        writeIndex = 0
        size = 0
    }
    fun overwrite(element: T) {
        if (isFull()) {
            buffer[readIndex] = element
            readIndex = (readIndex + 1) % capacity
            writeIndex = readIndex
        } else {
            write(element)
        }
    }
    private fun isFull(): Boolean = size == capacity
    private fun isEmpty(): Boolean = size == 0
}
