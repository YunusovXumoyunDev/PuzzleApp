package uz.smt.myapplication.screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.DialogScreenBinding
import uz.smt.myapplication.databinding.ScreenPuzzle2Binding
import uz.smt.myapplication.presenter.PuzzlePresenter3x3

class PuzzleScreen3x3 : Fragment() {
    private var _binding: ScreenPuzzle2Binding? = null
    private val binding: ScreenPuzzle2Binding get() = _binding!!
    private lateinit var repositoryPuzzle: RepositoryPuzzle
    private lateinit var presenter: PuzzlePresenter3x3
    private val looper = Looper.getMainLooper()
    private val handler = Handler(looper)
    private var time: Long = 0
    private var timeTxt: String = ""
    private var timeIsRunning = true
    private var dialog: AlertDialog? = null
    private val threadTimer = Thread {
        while (timeIsRunning) {
            Thread.sleep(1000)
            time++
            handler.post {
                val min = time / 60
                val sec = time % 60
                val minText = if (min > 9) min.toString() else "0$min"
                val secText = if (sec > 9) sec.toString() else "0$sec"
                binding.time.text = "$minText : $secText"
                timeTxt = "$minText : $secText"
            }
        }
    }
    private lateinit var dialogBinding: DialogScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenPuzzle2Binding.inflate(inflater, container, false)
        repositoryPuzzle = RepositoryPuzzle(requireContext())
        presenter = PuzzlePresenter3x3(repository = repositoryPuzzle, view = this)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUiClickable()
        loadDialog()
    }

    private fun loadUiClickable() {
        binding.btn3x31.setOnClickListener { presenter.click(0) }
        binding.btn3x32.setOnClickListener { presenter.click(1) }
        binding.btn3x33.setOnClickListener { presenter.click(2) }
        binding.btn3x34.setOnClickListener { presenter.click(3) }
        binding.btn3x35.setOnClickListener { presenter.click(4) }
        binding.btn3x36.setOnClickListener { presenter.click(5) }
        binding.btn3x37.setOnClickListener { presenter.click(6) }
        binding.btn3x38.setOnClickListener { presenter.click(7) }
        binding.btn3x39.setOnClickListener { presenter.click(8) }

        binding.restartBtn.setOnClickListener { presenter.clickRestart() }
        binding.toolbar.setNavigationOnClickListener { presenter.clickBack() }
    }

    private fun loadDialog() {
        dialogBinding = DialogScreenBinding.inflate(layoutInflater)
        dialog = AlertDialog.Builder(requireContext())
            .setTitle("Name")
            .setView(dialogBinding.root)
            .setPositiveButton("Ok") { _, _ ->
                openResult()
            }
            .setNegativeButton("Cancel") { _, _ ->

            }
            .create()
    }

    private fun openResult() {
        val name = dialogBinding.name.text.toString()
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                ResultScreen::class.java,
                bundleOf(
                    "time" to time,
                    "name" to name,
                    "count" to presenter.getCount()
                ),
                "Result Screen"
            )
            addToBackStack(null)
        }
    }


    private fun openDialog() {
        dialog?.show()
    }


    fun startTimer() {
        time = 0
        timeIsRunning = true
        threadTimer.start()
    }

    fun stopTimer() {
        timeIsRunning = false
        openDialog()
    }

    fun loadCount(count: Int) {
        binding.count.text = count.toString()
    }

    fun loadButtons(list: List<Int>) {
        list.forEachIndexed { index, i ->
            if (i == 9)
                hideVisible(index)
            else
                setText(i, index)
        }
    }

    fun clickBack() {
        parentFragmentManager.popBackStack()
    }

    fun setText(textBtn: Int, btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn3x31.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            1 -> binding.btn3x32.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            2 -> binding.btn3x33.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            3 -> binding.btn3x34.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            4 -> binding.btn3x35.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            5 -> binding.btn3x36.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            6 -> binding.btn3x37.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            7 -> binding.btn3x38.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            8 -> binding.btn3x39.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

        }
    }


    fun hideVisible(btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn3x31.apply { visibility = View.INVISIBLE }
            1 -> binding.btn3x32.apply { visibility = View.INVISIBLE }
            2 -> binding.btn3x33.apply { visibility = View.INVISIBLE }
            3 -> binding.btn3x34.apply { visibility = View.INVISIBLE }
            4 -> binding.btn3x35.apply { visibility = View.INVISIBLE }
            5 -> binding.btn3x36.apply { visibility = View.INVISIBLE }
            6 -> binding.btn3x37.apply { visibility = View.INVISIBLE }
            7 -> binding.btn3x38.apply { visibility = View.INVISIBLE }
            8 -> binding.btn3x39.apply { visibility = View.INVISIBLE }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}