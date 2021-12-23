@file:OptIn(ExperimentalStdlibApi::class)

package valkyrie

/**
 * keywords in any case, except for macros
 */
private val keywordSP = """(?x)
      \b(namespace|using|as)\b[*!?]?
    | \b(extension)\b
    | \b(if|else|which)\b
    | \b(for|in)\b | \b(while|loop)\b
    | \b(is|not|and|or)\b
    | \b(type|class)\b
    | \b(variant|bitflag)\b
    | \b(trait)\b
    | \b(extend|extends)\b
    | \b(let|def)\b
    | \b(object)\b
    | \b(match|with|case|when)\b
    """.toRegex()
private val punctuations = """(?x)\\
    | [.]{2}[=<]
    | [.]{1,3}
    | [{}\[\]()]
    | [,;$§¶^]
    | @[*!?@]?
    | \#[!]?
    # start with <, >
    | >{1,3} | >= | /> | ≥ | ⩾ | ≫
    | <{1,3} | <= | </ | ≤ | ⩽ | <: | <! 
    # start with :
    | ∷ | :: | :> | := | ≔ | :
    # start with -
    | -= | -> | ⟶ | -{1,2}
    # start with ~
    | ~> | ~
    # start with +
    | [+]= | [+]> | [+]{1,2}
    # start with *
    | [*]=?
    # start with / or % or ÷
    | /=?
    | ÷=?
    | %=?
    # start with &
    | &> | &{1,2} | ≻
    | [|]> | [|]{1,2} | ⊁
    | ⊻=? | ⊼=? | ⊽=? | [⩕⩖]
    # start with !
    | != | ≠ | !
    # start with ?
    | [?]{3} | [?]
    # start with =
    | => | ⇒
    | === | == | =
    # unicode
    | [∈∊∉⊑⋢⨳∀∁∂∃∄¬±√∛∜⊹⋗]
    | [⟦⟧⁅⁆⟬⟭]
    | [℃℉]
    | [↻↺⇆↹⇄⇋⇌⇅]
    #
    """.toRegex()
private val comments = """(?x)
      (?<s2>//)(?<t2>[^\n\r]*)  
    | (?<s3>/[*])(?<t3>[^\00]*?)(?<e3>[*]/)
    """.toRegex()
private val strings = """(?x)
      (?<s1>"{3,}|'{3,})(?<t1>[^\00]*?)(?<e1>\k<s1>)
    | (?<s2>')(?<t2>[^']*)(?<e2>')
    | (?<s3>")(?<t3>[^"]*)(?<e3>")
    """.toRegex()
private val numbers = """(?x)
      (?<s1>[_1-9][_\d]*[.][_\d]+)
    | (?<s2>0[.][_\d]+)
    | (?<s4>0[a-zA-Z][_\da-zA-Z]+)
    | (?<s3>0|[1-9][_\d]*)
    | (?<s5>[©®][0-9a-zA-Z]*)
""".toRegex()

