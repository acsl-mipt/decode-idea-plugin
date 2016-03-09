package ru.mipt.acsl.decode.idea.plugin

import ru.mipt.acsl.decode.model.domain.registry.Registry
import ru.mipt.acsl.decode.modeling.ModelingMessage
import ru.mipt.acsl.decode.modeling.TransformationResult

import scala.collection.immutable.Seq

/**
 * @author Artem Shein
 */
case class DecodeTransformationResult(result: Option[Registry], messages: Seq[ModelingMessage])
  extends TransformationResult[Registry]
