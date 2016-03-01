package ru.mipt.acsl.decode.idea.plugin

import com.intellij.codeInsight.completion._
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import ru.mipt.acsl.decode.parser.DecodeLanguage
import ru.mipt.acsl.decode.parser.psi.DecodeTypes

/**
 * @author Artem Shein
 */
class DecodeCompletionContributor extends CompletionContributor
{
    extend(CompletionType.BASIC,
        PlatformPatterns.psiElement(DecodeTypes.ELEMENT_NAME_RULE).withLanguage(DecodeLanguage.INSTANCE),
        new CompletionProvider[CompletionParameters]() {
            override protected def addCompletions(parameters: CompletionParameters, context: ProcessingContext,
                                                  result: CompletionResultSet) =
                System.out.println(parameters.getPosition.getParent.getNode)
        })
}
