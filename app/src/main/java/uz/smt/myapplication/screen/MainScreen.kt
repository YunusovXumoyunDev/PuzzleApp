package uz.smt.myapplication.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.model.LocalData
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.ScreenMainBinding
import uz.smt.myapplication.presenter.MainPresenter


class MainScreen : Fragment() {
    private var _binding: ScreenMainBinding? = null
    private val binding: ScreenMainBinding get() = _binding!!
    private lateinit var repository: RepositoryPuzzle
    private lateinit var presenter: MainPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenMainBinding.inflate(inflater, container, false)
        repository = RepositoryPuzzle(requireContext())
        presenter = MainPresenter(repository = repository, view = this)
        loadUiClickable()
        return binding.root

    }

    private fun loadUiClickable() {
        binding.firstBtn.setOnClickListener { presenter.clickFirstBtn() }
        binding.secondBtn.setOnClickListener { presenter.clickSecondBtn() }
        binding.thirdBtn.setOnClickListener { presenter.clickThirdBtn() }
    }

    fun setFirstBtn(data: LocalData) {
        binding.firstBtn.text = data.txt
    }

    fun setSecondBtn(data: LocalData) {
        binding.secondBtn.text = data.txt
    }

    fun setThirdBtn(data: LocalData) {
        binding.thirdBtn.text = data.txt
    }

    fun openPuzzleScreen4x4() {
        parentFragmentManager.commit {
            replace(
                R.id.fragment,
                PuzzleScreen4x4(),
                "Puzzle Screen"
            )
            addToBackStack(null)
        }
    }

    fun openPuzzleScreen3x3() {
        parentFragmentManager.commit {
            replace(
                R.id.fragment,
                PuzzleScreen3x3(),
                "Puzzle Screen2"
            )
            addToBackStack(null)
        }
    }

    fun openPuzzleScreen5x5() {
        parentFragmentManager.commit {
            replace(
                R.id.fragment,
                PuzzleScreen4x4(),
                "Puzzle Screen"
            )
            addToBackStack(null)
        }
    }
}