package dev.wolfthedeveloper

import kotlin.math.pow
import kotlin.random.Random

fun print(vararg messages: Any?, separator: String = " ", end: String = "\n", file: java.io.PrintStream = System.out, flush: Boolean = false) {
    file.print(messages.joinToString(separator) + end)
    if (flush) {
        file.flush()
    }
}

fun range(start: Int, end: Int, step: Int = 1): List<Int> {
    return List((end - start + step - 1) / step) { start + it * step }
}

fun input(prompt: String? = null): String {
    prompt?.let { print(it) }
    return readLine() ?: ""
}

fun len(item: Any?): Int {
    return when (item) {
        is String -> item.length
        is Array<*> -> item.size
        is List<*> -> item.size
        is Map<*, *> -> item.size
        else -> 0
    }
}

fun abs(number: Number): Number {
    return when (number) {
        is Int -> kotlin.math.abs(number)
        is Float -> kotlin.math.abs(number)
        is Double -> kotlin.math.abs(number)
        is Long -> kotlin.math.abs(number)
        else -> number
    }
}

fun max(vararg numbers: Number): Number? {
    return numbers.maxOfOrNull { it.toDouble() }
}

fun min(vararg numbers: Number): Number? {
    return numbers.minOfOrNull { it.toDouble() }
}

fun sum(vararg numbers: Number): Double {
    return numbers.sumOf { it.toDouble() }
}

fun pow(base: Double, exponent: Double): Double {
    return base.pow(exponent)
}

fun sqrt(number: Double): Double {
    return kotlin.math.sqrt(number)
}

fun exit(code: Int = 0) {
    System.exit(code)
}

fun sleep(seconds: Long) {
    Thread.sleep(seconds * 1000)
}

fun time(): Long {
    return System.currentTimeMillis()
}

fun toUpper(string: String): String {
    return string.uppercase()
}

fun toLower(string: String): String {
    return string.lowercase()
}

fun write(file: String, text: String) {
    java.io.File(file).writeText(text)
}

fun read(file: String): String {
    return java.io.File(file).readText()
}

fun int(string: String): Int {
    return try {
        string.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input for integer conversion: $string")
    }
}

fun float(string: String): Float {
    return try {
        string.toFloat()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input for float conversion: $string")
    }
}

fun double(string: String): Double {
    return try {
        string.toDouble()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input for double conversion: $string")
    }
}

fun long(string: String): Long {
    return try {
        string.toLong()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input for long conversion: $string")
    }
}

fun bool(string: String): Boolean {
    if (string.lowercase() == "true" || string.lowercase() == "false") {
        return string.toBoolean()
    } else {
        throw IllegalArgumentException("Invalid input for boolean conversion: $string")
    }
}

fun char(string: String): Char {
    if (string.length == 1) {
        return string.single()
    } else {
        throw IllegalArgumentException("Invalid input for char conversion: $string")
    }
}

fun debug(vararg messages: Any?) {
    val lineNumber = Exception().stackTrace[1].lineNumber
    return print("Line $lineNumber: " + messages.joinToString(", "), file = System.err)
}

fun randomInt(min: Int, max: Int): Int {
    return Random.nextInt(min, max)
}

fun randomFloat(min: Float, max: Float): Float {
    return Random.nextFloat() * (max - min) + min
}

fun randomDouble(min: Double, max: Double): Double {
    return Random.nextDouble(min, max)
}

fun randomLong(min: Long, max: Long): Long {
    return Random.nextLong(min, max)
}

fun ascii(): List <Char> {
    return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toList()
}

fun main() {
    val name = input("What is your name? ")
    print("Hello, $name!")
    debug("This is a debug message.")

    val n = range(1, 10)
    print(len(n))
    debug("This is a debug message.")
    print(ascii()['A'.toInt() - 65])
    print(randomInt(1, 10))
    print(n)
}