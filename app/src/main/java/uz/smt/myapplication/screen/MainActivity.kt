package uz.smt.myapplication.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import uz.smt.myapplication.R
import uz.smt.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(
                R.id.fragment,
                MainScreen(),
                "Puzzle Screen"
            )
            addToBackStack(null)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}