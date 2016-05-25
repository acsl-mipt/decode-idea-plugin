package ru.mipt.acsl.decode.idea.plugin

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import ru.mipt.acsl.decode.parser.DecodeFileType

/**
 * @author Artem Shein
 */
class DecodeFileTypeFactory extends FileTypeFactory {
    override def createFileTypes(consumer: FileTypeConsumer): Unit =
        consumer.consume(DecodeFileType, "decode")
}
