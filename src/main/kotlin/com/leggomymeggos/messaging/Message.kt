package com.leggomymeggos.messaging

class Message(val readers: List<Reader>)

data class ViewMessage(val mostRecentReaders: List<Reader>)

data class Reader(val name: String)

val elizabethBennet = Reader("Elizabeth Bennet")
val janeBennet = Reader("Jane Bennet")
val hermioneGranger = Reader("Hermione Granger")
val ginnyWeasley = Reader("Ginny Weasley")
val selinaKyle = Reader("Selina Kyle")
val generalOkoye = Reader("General Okoye")
val captainPhasma = Reader("Captain Phasma")

val allReaders = listOf(
    Reader("Diana Prince"),
    elizabethBennet,
    janeBennet,
    hermioneGranger,
    ginnyWeasley,
    selinaKyle,
    generalOkoye,
    captainPhasma
)


val readMessages = listOf(
    Message(
        listOf( // 2 readers (elizabeth and jane)
            elizabethBennet,
            janeBennet,
            hermioneGranger,
            ginnyWeasley,
            selinaKyle,
            generalOkoye,
            captainPhasma
        )
    ),
    Message(
        listOf( // 0 readers
            hermioneGranger,
            ginnyWeasley,
            captainPhasma
        )
    ),
    Message(listOf()), // 0 readers
    Message(
        listOf( // 1 reader (selina kyle)
            hermioneGranger,
            ginnyWeasley,
            selinaKyle,
            generalOkoye,
            captainPhasma
        )
    ),
    Message(
        listOf( // 1 reader (ginny)
            hermioneGranger,
            ginnyWeasley,
            generalOkoye,
            captainPhasma
        )
    ),
    Message(
        listOf( // 1 reader (phasma)
            hermioneGranger,
            generalOkoye,
            captainPhasma
        )
    ),
    Message(
        listOf( // 1 reader (okoye)
            hermioneGranger,
            generalOkoye
        )
    ),
    Message(
        listOf( // 1 reader (hermoine)
            hermioneGranger
        )
    )
)

