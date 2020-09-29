package com.toidv.idgenerator

import androidx.annotation.VisibleForTesting
import java.security.SecureRandom

class Generator(
    private val len: Int,
    private val prefix: String = "",
    private val separator: String = ""
) {

    private val secureRandom by lazy {
        SecureRandom()
    }

    fun generateId(): String {
        if (len <= 0) {
            throw IllegalArgumentException("len must greater than 0")
        }
        return prefix + separator + randomId(len, secureRandom, alphaNum)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun randomId(len: Int, secureRandom: SecureRandom, sources: String): String {
        val builder = StringBuilder()
        for (i in 0 until len) {
            val number = secureRandom.nextInt(sources.length)
            val character = sources[number]
            builder.append(character)
        }
        return builder.toString()
    }

    companion object {
        const val alphaNum = "123456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ"
    }
}