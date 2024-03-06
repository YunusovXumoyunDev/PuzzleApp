package uz.smt.myapplication.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.ScreenMainBinding
import uz.smt.myapplication.databinding.ScreenPuzzleBinding
import uz.smt.myapplication.presenter.MainPresenter
import uz.smt.myapplication.presenter.PuzzlePresenter


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
        return binding.root
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.firstBtn.setOnClickListener { presenter.firstBtnClick() }
        binding.secondBtn.setOnClickListener { presenter.secondBtnClick() }
        binding.thirdBtn.setOnClickListener { presenter.thirdBtnClick() }
    }

    fun firstBtn() {

    }

    fun secondBtn() {
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

    fun thirdBtn() {

    }
}