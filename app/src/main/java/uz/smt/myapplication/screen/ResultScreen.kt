package uz.smt.myapplication.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
    }

    fun loadUi() {
        binding.firstPlayerName.text = repository.getNameOne()
        binding.firstPlayerTime.text = repository.getTimeOne()
        binding.firstPlayerCount.text = repository.getCountOne()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}