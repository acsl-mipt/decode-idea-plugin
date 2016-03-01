package ru.mipt.acsl.decode.idea.plugin

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * @author Artem Shein
 */
class DecodeSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    override def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter =
        new DecodeSyntaxHighlighter
}
