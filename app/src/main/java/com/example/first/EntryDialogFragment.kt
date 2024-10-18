package com.example.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.first.data.JuiceColor
import com.example.first.databinding.FragmentEntryDialogBinding
import com.example.first.ui.InvAppViewModelProvider
import com.example.first.ui.JuiceEntryViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [EntryDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EntryDialogFragment : BottomSheetDialogFragment() {
    private val entryViewModel by viewModels<JuiceEntryViewModel> { InvAppViewModelProvider.Factory }
    var selectedColor: JuiceColor = JuiceColor.Red
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentEntryDialogBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEntryDialogBinding.bind(view)
        val args: EntryDialogFragmentArgs by navArgs()
        val juiceId = args.itemId

        binding.saveButton.setOnClickListener {
            entryViewModel.saveJuice(
                juiceId,
                binding.name.text.toString(),
                binding.description.text.toString(),
                selectedColor.name,
                binding.ratingBar.rating.toInt()
            )
            dismiss()
        }
    }

}