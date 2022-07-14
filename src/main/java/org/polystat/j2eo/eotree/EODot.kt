package org.polystat.j2eo.eotree

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import arrow.core.some
import tree.CompoundName

class EODot : EOExpr {
    var src: Option<EOExpr>
    var name: String

    constructor(name: String) : this(name.split("."))

    constructor(names: List<String>) {
        this.name = names.last()
        this.src = if (names.size > 1)
            EODot(names.dropLast(1)).some()
        else
            None
    }

    constructor(src: Option<EOExpr>, name: String) {
        this.src = src
        this.name = name
    }

    constructor(name: CompoundName) {
        // println("Mapping ${name.concatenatedJava()}")
        // Recursively build a dot expression
        this.src =
            if (name.names.size >= 2)
                Some(EODot(CompoundName(name.names.dropLast(1))))
            else None
        this.name = name.names.last()
    }

    override fun generateEO(indent: Int): String =
        src
            .map { src ->
                val text = src.generateEO(indent).split("\n")
                (listOf(text.first() + "." + name) + text.drop(1))
                    .joinToString("\n")
            }
            .getOrElse { indent(indent) + name }

    override fun toString(): String =
        src
            .map { src -> "$src.$name" }
            .getOrElse { name }
}

fun String.eoDot(): EODot = EODot(this)

fun CompoundName.eoDot(): EODot = EODot(this)

fun List<String>.eoDot(): EODot = EODot(this)
