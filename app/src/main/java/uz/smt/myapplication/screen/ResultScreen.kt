package uz.smt.myapplication.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.DialogScreenBinding
import uz.smt.myapplication.databinding.ResultDialogBinding
import uz.smt.myapplication.databinding.ScreenRecordBinding
import uz.smt.myapplication.databinding.ScreenResultBinding
import uz.smt.myapplication.presenter.ResultPresenter

class ResultScreen : Fragment(R.layout.screen_result) {
    private var _binding: ScreenResultBinding? = null
    private val binding: ScreenResultBinding get() = _binding!!
    private lateinit var presenter: ResultPresenter
    private lateinit var repository: RepositoryPuzzle


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenResultBinding.bind(view)
        repository = RepositoryPuzzle(requireContext())
        presenter = ResultPresenter(this, repository)
        loadUi()
        loadUiClickable()
    }

    private fun loadUi() {
        binding.playerName.text=getName()
    }
    private fun loadUiClickable() {
        binding.ok.setOnClickListener { presenter.clickOK() }
        binding.cancel.setOnClickListener { presenter.clickCANCEL() }
    }


    fun openRecord() {
        val timeTxt = requireArguments().getString("time")
        val name = requireArguments().getString("name")
        val count = requireArguments().getString("count")
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                RecordScreen::class.java,
                bundleOf(
                    "time" to timeTxt,
                    "name" to name,
                    "count" to count
                ),
                "Record Screen"
            )
            addToBackStack(null)
        }
    }

    fun backToPuzzle() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                PuzzleScreen(),
                "Puzzle Screen"
            )
            addToBackStack(null)
        }
    }

    fun getName(): String = requireArguments().getString("name").toString()
    fun getTime(): String = requireArguments().getString("time").toString()
    fun getCount(): String = requireArguments().getString("count").toString()
}