package ru.mipt.acsl.decode.idea.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import org.apache.commons.lang.NotImplementedException

/**
 * @author Artem Shein
 */
class DecodeGenerateSqliteForDecodeSourcesAction extends AnAction {

    val GROUP_DISPLAY_ID = "Decode SQLite Generation"

    override def actionPerformed(anActionEvent: AnActionEvent): Unit = throw new NotImplementedException
}
