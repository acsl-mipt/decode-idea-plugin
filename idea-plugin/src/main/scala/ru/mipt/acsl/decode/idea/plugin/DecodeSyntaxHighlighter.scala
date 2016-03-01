package ru.mipt.acsl.decode.idea.plugin

import com.intellij.lexer.Lexer
import ru.mipt.acsl.decode.parser.DecodeLexerAdapter
import ru.mipt.acsl.decode.parser.psi.DecodeTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

import scala.collection.immutable.HashSet
import DecodeTypes._

/**
 * @author Artem Shein
 */
class DecodeSyntaxHighlighter extends SyntaxHighlighterBase {
  import DecodeSyntaxHighlighter._

  override def getHighlightingLexer: Lexer = new DecodeLexerAdapter

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {

    import keys._
    tokenType match {
      case _ if KeywordTokens.contains(tokenType) => Keyword
      case ELEMENT_NAME_TOKEN | ESCAPED_NAME => ElementName
      case ELEMENT_ID => ElementId
      case NON_NEGATIVE_NUMBER => NonNegativeNumber
      case LEFT_BRACE | RIGHT_BRACE => Braces
      case LEFT_PAREN | RIGHT_PAREN => Parens
      case LEFT_BRACKET | RIGHT_BRACKET => Brackets
      case COMMA => Comma
      case SLASH => Slash
      case DOT => Dot
      case STAR => Star
      case COMMENT => LineComment
      case MULTILINE_COMMENT => BlockComment
      case STRING_VALUE | STRING | STRING_UNARY_QUOTES => String
      case TokenType.BAD_CHARACTER => BadCharacter
      case _ => Empty
    }
  }
}

object DecodeSyntaxHighlighter {
  import TextAttributesKey.createTextAttributesKey
  import DefaultLanguageHighlighterColors._

  private object keys {
    val Empty = Array.empty[TextAttributesKey]
    val Keyword = Array(createTextAttributesKey("DECODE_KEYWORD", KEYWORD))
    val BadCharacter = Array(createTextAttributesKey("DECODE_BAD_CHARACTER", INVALID_STRING_ESCAPE))
    val ElementName = Array(createTextAttributesKey("DECODE_ELEMENT_NAME", IDENTIFIER))
    val ElementId = Array(createTextAttributesKey("DECODE_ELEMENT_ID", IDENTIFIER))
    val Braces = Array(createTextAttributesKey("DECODE_BRACE", BRACES))
    val Parens = Array(createTextAttributesKey("DECODE_PAREN", PARENTHESES))
    val Comma = Array(createTextAttributesKey("DECODE_COMMA", COMMA))
    val LineComment = Array(createTextAttributesKey("DECODE_LINE_COMMENT", LINE_COMMENT))
    val BlockComment = Array(createTextAttributesKey("DECODE_BLOCK_COMMENT", BLOCK_COMMENT))
    val Brackets = Array(createTextAttributesKey("DECODE_BRACKET", BRACKETS))
    val Slash = Array(createTextAttributesKey("DECODE_SLASH", MARKUP_TAG))
    val Dot = Array(createTextAttributesKey("DECODE_DOT", DOT))
    val NonNegativeNumber = Array(createTextAttributesKey("DECODE_NON_NEGATIVE_NUMBER", NUMBER))
    val Star = Array(createTextAttributesKey("DECODE_STAR", OPERATION_SIGN))
    val String = Array(createTextAttributesKey("DECODE_STRING", STRING))
  }

  private val KeywordTokens = HashSet(NAMESPACE, COMPONENT, COMMAND, DYNAMIC,
    EVENT, MESSAGE, STATUS, PARAMETER,
    ARRAY, BOOL, ENUM, NATIVE, FINAL,
    FLOAT, INT, UINT, STRUCT, UNIT_TOKEN,
    TYPE_KEYWORD, SUBCOMPONENT, DISPLAY, PLACEMENT,
    BEFORE, AFTER, COLON, ALIAS, WITH,
    PARAMETERS, IMPORT, AS, DEFAULT, LANGUAGE,
    VAR, EXTENDS)
}
