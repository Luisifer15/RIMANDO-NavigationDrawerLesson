package ph.edu.auf.navigationdrawerlesson.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ph.edu.auf.navigationdrawerlesson.R
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentLoveQuotesBinding
import ph.edu.auf.navigationdrawerlesson.helpers.QuotesGenerator
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager
import ph.edu.auf.navigationdrawerlesson.helpers.constants.SharedPrefKeys

class LoveQuotesFragment : Fragment() {

    private var _binding: FragmentLoveQuotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var quotesGenerator: QuotesGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoveQuotesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quotesGenerator = QuotesGenerator.generateLoveQuotes().build()

        val quote = quotesGenerator.getRandomQuote()
        binding.txtLoveQuote.text = quote.quote
        binding.txtLoveQuoteAuthor.text = quote.author

        binding.btnRandomizeQuote.setOnClickListener {
            val newQuote = quotesGenerator.getRandomQuote()
            binding.txtLoveQuote.text = newQuote.quote
            binding.txtLoveQuoteAuthor.text = newQuote.author
        }

        binding.btnSaveQuote.setOnClickListener {
            val quoteText = binding.txtLoveQuote.text.toString()
            val quoteAuthor = binding.txtLoveQuoteAuthor.text.toString()
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