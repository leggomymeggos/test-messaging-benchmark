package com.leggomymeggos.messaging

class MessageTransformer {
    fun transform(messages: List<Message> = readMessages): List<ViewMessage> {
        return messages
            .map { message ->
                ViewMessage(
                    message.readers.mapNotNull { reader ->
                        when (message) {
                            messages.last { it.readers.contains(reader) } -> reader
                            else -> null
                        }
                    })
            }
    }

    fun transform2(
        messages: List<Message> = readMessages,
        channelMembers: List<Reader> = allReaders
    ): List<ViewMessage> {
        val lastReadMessages = channelMembers.map { reader ->
            reader to messages.lastOrNull { it.readers.contains(reader) }
        }.toMap()

        return messages.map { message ->
            ViewMessage(
                message.readers.mapNotNull { reader ->
                    when (message) {
                        lastReadMessages[reader] -> reader
                        else -> null
                    }
                })
        }
    }

    fun transform3(
        messages: List<Message> = readMessages
    ): List<ViewMessage> {
        val mutableMap = mutableMapOf<Reader, Int>()

        messages.forEachIndexed { index, message ->
            message.readers.forEach { reader ->
                mutableMap[reader] = index
            }
        }

        return messages.mapIndexed { index, _ ->
            val filterValues: Map<Reader, Int> = mutableMap.filterValues { it == index }
            ViewMessage(
                filterValues.keys.toList()
            )
        }
    }
}