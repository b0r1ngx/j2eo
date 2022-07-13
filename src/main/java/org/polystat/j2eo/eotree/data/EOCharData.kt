package org.polystat.j2eo.eotree.data

/**
 * EBNF representation:
 * `
 * /'([^']|\\\d+)'/
` *
 */
class EOCharData(var c: Char) : EOData() {
    override fun generateEO(indent: Int): String {
        return "'$c'"
    }
}
