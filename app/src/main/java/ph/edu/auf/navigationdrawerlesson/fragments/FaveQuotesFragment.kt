package ph.edu.auf.navigationdrawerlesson.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ph.edu.auf.navigationdrawerlesson.R
import ph.edu.auf.navigationdrawerlesson.databinding.FragmentFaveQuotesBinding
import ph.edu.auf.navigationdrawerlesson.helpers.SharedPreferenceManager
import ph.edu.auf.navigationdrawerlesson.helpers.constants.SharedPrefKeys

class FaveQuotesFragment : Fragment() {

    private var _binding: FragmentFaveQuotesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFaveQuotesBinding.inflate(inflater,container,false)

        val quote = SharedPreferenceManager.getString(SharedPrefKeys.FAVEQUOTE.key, "No favorite quote saved")
        val author = SharedPreferenceManager.getString(SharedPrefKeys.FAVEQUOTE_AUTHOR.key, "No author saved")
        binding.txtFaveQuote.text = quote
        binding.txtFaveQuoteAuthor.text = author

        // Delete the favorite quote
        binding.btnRemoveFave.setOnClickListener {
            SharedPreferenceManager.removeString(SharedPrefKeys.FAVEQUOTE.key)
            SharedPreferenceManager.removeString(SharedPrefKeys.FAVEQUOTE_AUTHOR.key)
            binding.txtFaveQuote.text = "No favorite quote saved"
            binding.txtFaveQuoteAuthor.text = "No author saved"
            Toast.makeText(activity, "Quote deleted!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}