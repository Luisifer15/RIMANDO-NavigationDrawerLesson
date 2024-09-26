package ph.edu.auf.navigationdrawerlesson.helpers

import kotlin.random.Random

class QuotesGenerator private constructor(private val quotes: List<String>){
    fun getRandomQuote(): String {
        val random = Random.nextInt(0,quotes.size)
        return quotes[random]
    }

    class QuoteBuilder{
        internal val quotes = mutableListOf<String>()
        fun build() = QuotesGenerator(quotes)
    }

    companion object {
        private val loveQuotes = listOf(
            "I love you.",
            "I love you more than yesterday.",
            "I love you more than I did yesterday.",
            "I love you more than I did yesterday and less than I will tomorrow.",
        )

        private val motivationalQuotes = listOf(
            "You are capable of amazing things.",
            "You are capable of more than you know.",
            "You are capable of more than you think.",
            "You are capable of more than you think you are.",
        )

        private val gamingQuotes = listOf(
            "\"Courage need not be remembered, for it is never forgotten.\"  \n–Zelda, The Legend of Zelda: Breath of the Wild",
            "\"I used to be an adventurer like you, but then I took an arrow to the knee.\"  \n-Random Guard, Skyrim",
            "\"There is no honor in death.\"  \n-Jin Sakai, Ghost of Tsushima",
            "\"The right man in the wrong place can make all the difference in the world.\"  \n-The G-Man, Half-Life 2",
            "\"War. War never changes.\"  \n-Narrator, Fallout",
        )

        private val cyberpunkQuotes = listOf(
            "\"Give yourself time. Ideas'll come. Life'll shake you, roll you, maybe embrace you. The music'll find you.\"  \n-Johnny Silverhand",
            "\"In a city of dreams, you either survive or get swallowed up.\"  \n-V",
            "\"The only limit to what you can do is what you're willing to become.\"  \n-Johnny Silverhand",
            "\"A happy ending? For folks like us? Wrong city, wrong people.\"  \n-Johnny Silverhand",
            "\"He burned down half the city just to prove he was right and burned the other half just for fun\"  \n-Rogue Amendiares",
        )

        private val witcherQuotes = listOf(
            "\"Evil is evil. Lesser, greater, middling… makes no difference. The degree is arbitrary, the definition's blurred.\" \n-Geralt of Rivia",
            "\"People like to invent monsters and monstrosities. Then they seem less monstrous themselves.\"  \n-Geralt of Rivia",
            "\"You mistake stars reflected in a pond for the night sky.\"  \n-Vilgefortz of Roggeveen",
            "\"There is a grain of truth in every fairy tale.\" \n-Geralt of Rivia",
            "\"For Whoever Doesn’t Overcome The Cowardice Inside Themselves Will Die Of Fear To The End Of Their Days.\" \n-Yennefer of Vengerberg",
        )

        fun generateWitcherQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(witcherQuotes) }
        }

        fun generateCyberpunkQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(cyberpunkQuotes) }
        }

        fun generateGamingQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(gamingQuotes) }
        }

        fun generateLoveQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(loveQuotes) }
        }

        fun generateAllQuotes(): QuoteBuilder {
            val allQuotes = mutableListOf<String>()
            allQuotes.addAll(loveQuotes)
            allQuotes.addAll(motivationalQuotes)
            allQuotes.addAll(gamingQuotes)
            allQuotes.addAll(cyberpunkQuotes)
            allQuotes.addAll(witcherQuotes)
            return QuoteBuilder().apply { quotes.addAll(allQuotes) }
        }

    }

}