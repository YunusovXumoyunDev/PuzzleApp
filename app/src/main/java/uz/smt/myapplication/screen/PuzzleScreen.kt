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
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.data.repository.RepositoryPuzzle
import uz.smt.myapplication.databinding.DialogScreenBinding
import uz.smt.myapplication.databinding.ScreenPuzzleBinding
import uz.smt.myapplication.presenter.PuzzlePresenter

class PuzzleScreen : Fragment() {
    private var _binding: ScreenPuzzleBinding? = null
    private val binding: ScreenPuzzleBinding get() = _binding!!
    private lateinit var repositoryPuzzle: RepositoryPuzzle
    private lateinit var presenter: PuzzlePresenter
    private val looper = Looper.getMainLooper()
    private val handler = Handler(looper)
    private var time = 0
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
        _binding = ScreenPuzzleBinding.inflate(inflater, container, false)
        repositoryPuzzle = RepositoryPuzzle(requireContext())
        presenter = PuzzlePresenter(repository = repositoryPuzzle, view = this)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUiClickable()
        loadDialog()
    }

    private fun loadUiClickable() {
        binding.btn1.setOnClickListener { presenter.click(0) }
        binding.btn2.setOnClickListener { presenter.click(1) }
        binding.btn3.setOnClickListener { presenter.click(2) }
        binding.btn4.setOnClickListener { presenter.click(3) }
        binding.btn5.setOnClickListener { presenter.click(4) }
        binding.btn6.setOnClickListener { presenter.click(5) }
        binding.btn7.setOnClickListener { presenter.click(6) }
        binding.btn8.setOnClickListener { presenter.click(7) }
        binding.btn9.setOnClickListener { presenter.click(8) }
        binding.btn10.setOnClickListener { presenter.click(9) }
        binding.btn11.setOnClickListener { presenter.click(10) }
        binding.btn12.setOnClickListener { presenter.click(11) }
        binding.btn13.setOnClickListener { presenter.click(12) }
        binding.btn14.setOnClickListener { presenter.click(13) }
        binding.btn15.setOnClickListener { presenter.click(14) }
        binding.btn16.setOnClickListener { presenter.click(15) }

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
                    "time" to timeTxt,
                    "name" to name,
                    "count" to presenter.getCount()),
                "Result Screen"
            )
            addToBackStack(null)
        }
    }


    private fun openDialog() {
        dialog?.show()
    }
    fun clickBack(){
        parentFragmentManager.popBackStack()
    }
    fun getName(): String = dialogBinding.name.text.toString()

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
            if (i == 16)
                hideVisible(index)
            else
                setText(i, index)
        }
    }

    fun setText(textBtn: Int, btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn1.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            1 -> binding.btn2.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            2 -> binding.btn3.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            3 -> binding.btn4.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            4 -> binding.btn5.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            5 -> binding.btn6.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            6 -> binding.btn7.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            7 -> binding.btn8.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            8 -> binding.btn9.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            9 -> binding.btn10.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            10 -> binding.btn11.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            11 -> binding.btn12.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            12 -> binding.btn13.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            13 -> binding.btn14.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            14 -> binding.btn15.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }

            15 -> binding.btn16.apply {
                text = textBtn.toString()
                visibility = View.VISIBLE
            }
        }
    }

    fun hideVisible(btnIndex: Int) {
        when (btnIndex) {
            0 -> binding.btn1.apply { visibility = View.INVISIBLE }
            1 -> binding.btn2.apply { visibility = View.INVISIBLE }
            2 -> binding.btn3.apply { visibility = View.INVISIBLE }
            3 -> binding.btn4.apply { visibility = View.INVISIBLE }
            4 -> binding.btn5.apply { visibility = View.INVISIBLE }
            5 -> binding.btn6.apply { visibility = View.INVISIBLE }
            6 -> binding.btn7.apply { visibility = View.INVISIBLE }
            7 -> binding.btn8.apply { visibility = View.INVISIBLE }
            8 -> binding.btn9.apply { visibility = View.INVISIBLE }
            9 -> binding.btn10.apply { visibility = View.INVISIBLE }
            10 -> binding.btn11.apply { visibility = View.INVISIBLE }
            11 -> binding.btn12.apply { visibility = View.INVISIBLE }
            12 -> binding.btn13.apply { visibility = View.INVISIBLE }
            13 -> binding.btn14.apply { visibility = View.INVISIBLE }
            14 -> binding.btn15.apply { visibility = View.INVISIBLE }
            15 -> binding.btn16.apply { visibility = View.INVISIBLE }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}