package com.toidv.idgenerator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.mockito.Mockito.*


class GeneratorUnitTest {
    private val prefix = "prefix"
    private val separator = "_"
    private val length = 10

    @Test
    fun generator_isSuccess() {
        val generator = Generator(length)
        val id = generator.generateId()
        assertEquals(id.length, length)
    }

    @Test
    fun generator_FullConstructor_isSuccess() {
        val generator = Generator(length, prefix, separator)
        val id = generator.generateId()
        assertEquals(id.length, length + prefix.length + separator.length)
    }

    @Test(expected = IllegalArgumentException::class)
    fun generator_isFail() {
        val generator = Generator(0)
        generator.generateId()
    }

    fun <T> anyT(): T = any<T>()

    @Test
    fun randomID_isSuccess() {
        val stock: Generator = spy(Generator(1, prefix, separator))
        doReturn("1").`when`(stock).randomId(anyInt(), anyT(), anyString())
        val id = stock.generateId()
        assertEquals(id, prefix + separator + "1")
    }

    @Test
    fun randomID_isFail() {
        val stock: Generator = spy(Generator(1, prefix, separator))
        doReturn("2").`when`(stock).randomId(anyInt(), anyT(), anyString())
        val id = stock.generateId()
        assertNotEquals(id, prefix + separator + "1")
    }
}
