package ru.mipt.acsl.decode.idea.plugin

import ru.mipt.acsl.decode.model.registry.Registry
import ru.mipt.acsl.modeling.{ModelingMessage, TransformationResult}

import scala.collection.immutable.Seq

/**
 * @author Artem Shein
 */
case class DecodeTransformationResult(result: Option[Registry], messages: Seq[ModelingMessage])
  extends TransformationResult[Registry]
