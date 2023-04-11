package com.ulyanenko.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ulyanenko.composition.R
import com.ulyanenko.composition.databinding.FragmentGameBinding
import com.ulyanenko.composition.domain.entity.GameResult
import com.ulyanenko.composition.domain.entity.Level


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    private lateinit var level: Level

    private var _binding:FragmentGameBinding? =null
    private val binding:FragmentGameBinding
    get() = _binding?:throw RuntimeException("FragmentWelcomeBinding ==null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parsArgs(){
        level= requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    private fun launchGameFinishedFragment(gameResult: GameResult){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }


    companion object{

        const val NAME= "GameFragment"
        private const val KEY_LEVEL="level"
        fun newInstance(level:Level):GameFragment{
            return GameFragment().apply {
                arguments = Bundle().apply {
                putSerializable(KEY_LEVEL, level)
                }
            }
        }
    }

}