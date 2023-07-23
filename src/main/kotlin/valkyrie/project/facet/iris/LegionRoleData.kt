package valkyrie.project.facet.iris

class LegionRoleData {
    var roleName: String? = "Saber"
    var roleVersion: String? = null

    constructor()

    fun roleNameAvailable(): List<String> {
        return listOf(
            "Saber",
            "Browser",
            "Caster",
            "Archer",
            "Swordmaster",
            "Sorcerer",
            "Warrior",
            "Mage",
            "Assassin",
            "Ranger",
            "Bard",
            "Rogue",
            "Ninja",
            "Samurai",
            "Monk",
            "Priest",
            "Wizard",
            "Warlock",
            "Druid",
            "Paladin",
            "Dark Knight"
        )
    }

    fun roleVersionAvailable(): List<String> {
        return listOf("2024.1.0.0", "2024.0.0.0", "nightly (2024.4.1)")
    }

}