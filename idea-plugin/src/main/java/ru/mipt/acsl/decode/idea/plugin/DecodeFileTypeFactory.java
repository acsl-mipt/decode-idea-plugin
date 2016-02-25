package ru.mipt.acsl.decode.idea.plugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;
import ru.mipt.acsl.decode.parser.DecodeFileType$;

/**
 * @author Artem Shein
 */
public class DecodeFileTypeFactory extends FileTypeFactory
{
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer)
    {
        consumer.consume(DecodeFileType$.MODULE$.instance(), "decode");
    }
}
