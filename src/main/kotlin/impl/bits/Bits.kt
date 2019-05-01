package impl.bits

internal object Bits {
	fun getBit(subject: Int, index: Int) = (subject and (1 shl index)).toByte()

	fun setBit(subject: Int, index: Int) = subject or (1 shl index)

	fun clearBit(subject: Int, index: Int) = subject and (1 shl index).inv()
}
