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

    private fun loadUi() {
        binding.firstPlayerName.text = repository.getRecord1().user
        binding.secondPlayerName.text = repository.getRecord2().user
        binding.thirdPlayerName.text = repository.getRecord3().user
        binding.fourthPlayerName.text = repository.getRecord4().user

        binding.firstPlayerCount.text = repository.getRecord1().count.toString()
        binding.secondPlayerCount.text = repository.getRecord2().count.toString()
        binding.thirdPlayerCount.text = repository.getRecord3().count.toString()
        binding.fourthPlayerCount.text = repository.getRecord4().count.toString()

        binding.firstPlayerTime.text = repository.getRecord1().time.toString()
        binding.secondPlayerTime.text = repository.getRecord2().time.toString()
        binding.thirdPlayerTime.text = repository.getRecord3().time.toString()
        binding.fourthPlayerTime.text = repository.getRecord4().time.toString()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}