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

        binding.txtWitcherQuote.text = quotesGenerator.getRandomQuote()

        binding.btnRandomizeQuote.setOnClickListener {
            binding.txtWitcherQuote.text = quotesGenerator.getRandomQuote()
        }

        binding.btnSaveQuote.setOnClickListener {
            val quote = binding.txtWitcherQuote.text.toString()
            SharedPreferenceManager.putString(SharedPrefKeys.FAVEQUOTE.key, quote)
            Toast.makeText(activity, "Quote saved!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}