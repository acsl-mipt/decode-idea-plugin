package ru.mipt.acsl.decode.idea.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang.NotImplementedException;

/**
 * @author Artem Shein
 */
public class DecodeGenerateSqliteForDecodeSourcesAction extends AnAction
{

    public static final String GROUP_DISPLAY_ID = "Decode SQLite Generation";

    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {
        throw new NotImplementedException();
    }
}
