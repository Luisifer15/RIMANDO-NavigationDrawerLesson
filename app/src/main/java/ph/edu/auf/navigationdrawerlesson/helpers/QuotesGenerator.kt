package ph.edu.auf.navigationdrawerlesson.helpers

import kotlin.random.Random

data class Quote(val quote: String, val author: String)

class QuotesGenerator private constructor(private val quotes: List<Quote>){
    fun getRandomQuote(): Quote {
        val random = Random.nextInt(0,quotes.size)
        return quotes[random]
    }

    class QuoteBuilder{
        internal val quotes = mutableListOf<Quote>()
        fun build() = QuotesGenerator(quotes)
    }

    companion object {
        private val loveQuotes = listOf(
            Quote("I love you.", "Unknown"),
            Quote("I love you more than yesterday.", "Unknown"),
            Quote("I love you more than I did yesterday.", "Unknown"),
            Quote("I love you more than I did yesterday and less than I will tomorrow.", "Unknown")
        )

        private val motivationalQuotes = listOf(
            Quote("You are capable of amazing things.", "Unknown"),
            Quote("You are capable of more than you know.", "Unknown"),
            Quote("You are capable of more than you think.", "Unknown"),
            Quote("You are capable of more than you think you are.", "Unknown")
        )

        private val gamingQuotes = listOf(
            Quote("\"Courage need not be remembered, for it is never forgotten.\"", "Zelda, The Legend of Zelda: Breath of the Wild"),
            Quote("\"I used to be an adventurer like you, but then I took an arrow to the knee.\"", "Random Guard, Skyrim"),
            Quote("\"There is no honor in death.\"", "Jin Sakai, Ghost of Tsushima"),
            Quote("\"The right man in the wrong place can make all the difference in the world.\"", "The G-Man, Half-Life 2"),
            Quote("\"War. War never changes.\"", "Narrator, Fallout")
        )

        private val cyberpunkQuotes = listOf(
            Quote("\"Give yourself time. Ideas'll come. Life'll shake you, roll you, maybe embrace you. The music'll find you.\"", "Johnny Silverhand"),
            Quote("\"In a city of dreams, you either survive or get swallowed up.\"", "V"),
            Quote("\"The only limit to what you can do is what you're willing to become.\"", "Johnny Silverhand"),
            Quote("\"A happy ending? For folks like us? Wrong city, wrong people.\"", "Johnny Silverhand"),
            Quote("\"He burned down half the city just to prove he was right and burned the other half just for fun\"", "Rogue Amendiares")
        )

        private val witcherQuotes = listOf(
            Quote("\"Evil is evil. Lesser, greater, middling… makes no difference. The degree is arbitrary, the definition's blurred.\"", "Geralt of Rivia"),
            Quote("\"People like to invent monsters and monstrosities. Then they seem less monstrous themselves.\"", "Geralt of Rivia"),
            Quote("\"You mistake stars reflected in a pond for the night sky.\"", "Vilgefortz of Roggeveen"),
            Quote("\"There is a grain of truth in every fairy tale.\"", "Geralt of Rivia"),
            Quote("\"For Whoever Doesn’t Overcome The Cowardice Inside Themselves Will Die Of Fear To The End Of Their Days.\"", "Yennefer of Vengerberg")
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
            val allQuotes = mutableListOf<Quote>()
            allQuotes.addAll(loveQuotes)
            allQuotes.addAll(motivationalQuotes)
            allQuotes.addAll(gamingQuotes)
            allQuotes.addAll(cyberpunkQuotes)
            allQuotes.addAll(witcherQuotes)
            return QuoteBuilder().apply { quotes.addAll(allQuotes) }
        }

    }

}