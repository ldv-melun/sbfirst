package fr.vincimelun.sbfirst

import fr.vincimelun.sbfirst.controller.min
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests constructor(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert hello page title, content and status code`() {
        val httpEntity = restTemplate.getForEntity<String>("/")
        assertEquals(httpEntity.statusCode, HttpStatus.OK)
        assertNotNull(httpEntity.body)
        assertTrue(httpEntity.body!!.contains("<h1>Hello world !</h1>"))
    }

    @Test
    fun `Assert demo-ge ERREUR`() {
        val httpEntity = restTemplate.getForEntity<String>("/demo-ge")
        assertEquals(httpEntity.statusCode, HttpStatus.OK)
        assertNotNull(httpEntity.body)
        assertTrue(httpEntity.body!!.contains("ERREUR : min sur liste vide IMPOSSIBLE"))
    }

}