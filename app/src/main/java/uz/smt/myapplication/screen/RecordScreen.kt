package uz.smt.myapplication.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.ScreenRecordBinding
import uz.smt.myapplication.databinding.ScreenResultBinding
import uz.smt.myapplication.presenter.RecordPresenter
import uz.smt.myapplication.presenter.ResultPresenter

class RecordScreen : Fragment(R.layout.screen_record) {
    private var _binding: ScreenRecordBinding? = null
    private val binding: ScreenRecordBinding get() = _binding!!
    private lateinit var presenter: RecordPresenter
    private lateinit var repository: RepositoryPuzzle
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenRecordBinding.bind(view)
        repository = RepositoryPuzzle(requireContext())
        presenter = RecordPresenter(this, repository)
        loadUi()

    }

    fun loadUi() {
        binding.firstPlayerName.text = repository.getNameOne()
        binding.firstPlayerTime.text = requireArguments().getString("time").toString()
        binding.firstPlayerCount.text = repository.getCountOne()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}