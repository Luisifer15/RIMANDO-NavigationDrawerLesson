package ph.edu.auf.navigationdrawerlesson.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentWitcherQuotesBinding
import ph.edu.auf.navigationdrawerlesson.helpers.QuotesGenerator
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager
import ph.edu.auf.navigationdrawerlesson.helpers.constants.SharedPrefKeys

class WitcherQuotesFragment : Fragment() {

    private var _binding: FragmentWitcherQuotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var quotesGenerator: QuotesGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWitcherQuotesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotesGenerator = QuotesGenerator.generateWitcherQuotes().build()

        val quote = quotesGenerator.getRandomQuote()
        binding.txtWitcherQuote.text = quote.quote
        binding.txtWitcherQuoteAuthor.text = quote.author


        binding.btnRandomizeQuote.setOnClickListener {
            val newQuote = quotesGenerator.getRandomQuote()
            binding.txtWitcherQuote.text = newQuote.quote
            binding.txtWitcherQuoteAuthor.text = newQuote.author
        }

        binding.btnSaveQuote.setOnClickListener {
            val quoteText = binding.txtWitcherQuote.text.toString()
            val quoteAuthor = binding.txtWitcherQuoteAuthor.text.toString()
            SharedPreferenceManager.putString(SharedPrefKeys.FAVEQUOTE.key, quoteText)
            SharedPreferenceManager.putString(SharedPrefKeys.FAVEQUOTE_AUTHOR.key, quoteAuthor)
            Toast.makeText(activity, "Quote saved!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}