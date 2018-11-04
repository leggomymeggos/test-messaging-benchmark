package com.leggomymeggos.messaging

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneOffset

class MessageTransformerTest {

    lateinit var messageTransformer: MessageTransformer

    @Before
    fun setup() {
        messageTransformer = MessageTransformer()
    }

    @Test
    fun `transform sets readers on the most recently read message`() {
        val transformedMessages = messageTransformer.transform(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform handles gaps in data`() {
        val transformedMessages = messageTransformer.transform(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform handles multiple last readers`() {
        val transformedMessages = messageTransformer.transform(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger, generalOkoye)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger, generalOkoye)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform with default messaging list`() {
        val transformedMessages = messageTransformer.transform()

        assertThat(transformedMessages[0].mostRecentReaders).containsExactly(elizabethBennet, janeBennet)
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[3].mostRecentReaders).containsExactly(selinaKyle)
        assertThat(transformedMessages[4].mostRecentReaders).containsExactly(ginnyWeasley)
        assertThat(transformedMessages[5].mostRecentReaders).containsExactly(captainPhasma)
        assertThat(transformedMessages[6].mostRecentReaders).containsExactly(generalOkoye)
        assertThat(transformedMessages[7].mostRecentReaders).containsExactly(hermioneGranger)
    }

    @Test
    fun `transform2 sets readers on the most recently read message`() {
        val transformedMessages = messageTransformer.transform2(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform2 handles gaps in data`() {
        val transformedMessages = messageTransformer.transform2(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform2 handles multiple last readers`() {
        val transformedMessages = messageTransformer.transform2(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger, generalOkoye)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger, generalOkoye)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform2 with default messaging list`() {
        val startTime = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()
        val transformedMessages = messageTransformer.transform2()
        val endTime = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()

        println("transform2: " + (endTime - startTime))
        assertThat(transformedMessages[0].mostRecentReaders).containsExactly(elizabethBennet, janeBennet)
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[3].mostRecentReaders).containsExactly(selinaKyle)
        assertThat(transformedMessages[4].mostRecentReaders).containsExactly(ginnyWeasley)
        assertThat(transformedMessages[5].mostRecentReaders).containsExactly(captainPhasma)
        assertThat(transformedMessages[6].mostRecentReaders).containsExactly(generalOkoye)
        assertThat(transformedMessages[7].mostRecentReaders).containsExactly(hermioneGranger)
    }

    @Test
    fun `transform3 sets readers on the most recently read message`() {
        val transformedMessages = messageTransformer.transform3(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform3 handles gaps in data`() {
        val transformedMessages = messageTransformer.transform3(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform3 handles multiple last readers`() {
        val transformedMessages = messageTransformer.transform3(
            listOf(
                Message(listOf(hermioneGranger)),
                Message(listOf()),
                Message(listOf(hermioneGranger, generalOkoye)),
                Message(listOf())
            )
        )

        assertThat(transformedMessages[0].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).containsExactly(hermioneGranger, generalOkoye)
        assertThat(transformedMessages[3].mostRecentReaders).isEmpty()
    }

    @Test
    fun `transform3 with default messaging list`() {
        val transformedMessages = messageTransformer.transform3()

        assertThat(transformedMessages[0].mostRecentReaders).containsExactly(elizabethBennet, janeBennet)
        assertThat(transformedMessages[1].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[2].mostRecentReaders).isEmpty()
        assertThat(transformedMessages[3].mostRecentReaders).containsExactly(selinaKyle)
        assertThat(transformedMessages[4].mostRecentReaders).containsExactly(ginnyWeasley)
        assertThat(transformedMessages[5].mostRecentReaders).containsExactly(captainPhasma)
        assertThat(transformedMessages[6].mostRecentReaders).containsExactly(generalOkoye)
        assertThat(transformedMessages[7].mostRecentReaders).containsExactly(hermioneGranger)
    }
}