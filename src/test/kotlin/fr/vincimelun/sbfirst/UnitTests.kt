package fr.vincimelun.sbfirst

import fr.vincimelun.sbfirst.controller.min
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UnitTests constructor() {

    @Test
    fun `minimum tab normal`() {
        val tab1 = intArrayOf(2, 3, 0, 1, 7)
        val tab2 = intArrayOf(2, 2, 2, 2, 2)
        assertEquals(0, min(tab1))
        assertEquals(2, min(tab2))
    }

}