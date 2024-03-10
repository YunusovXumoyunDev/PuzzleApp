package uz.smt.myapplication.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
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
        binding.playerName.text = requireArguments().getString("name")
    }

    private fun loadUiClickable() {
        binding.ok.setOnClickListener { presenter.clickOK() }
        binding.cancel.setOnClickListener { presenter.clickCANCEL() }
    }


    fun openRecord() {
        val time = requireArguments().getString("time")
        val name = requireArguments().getString("name")
        val count = requireArguments().getInt("count")
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                RecordScreen::class.java,
                bundleOf(
                    "time" to time,
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
                MainScreen(),
                "Main Screen"
            )
            addToBackStack(null)
        }
    }

    fun getCount(): Int = requireArguments().getInt("count")
    fun getTime():Long=requireArguments().getLong("time")
    fun getName():String=requireArguments().getString("name").toString()
}