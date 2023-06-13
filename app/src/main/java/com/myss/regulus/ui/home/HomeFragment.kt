package com.myss.regulus.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.myss.regulus.databinding.FragmentHomeBinding
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation


import android.widget.Button
import android.widget.ImageButton

import androidx.navigation.fragment.findNavController
import com.myss.regulus.R
import com.myss.regulus.suerteActivity


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnEstudiantes: Button = binding.btnEstudiantes
        val btnProfesores: Button = binding.btnProfesores
        val imageView: ImageButton = binding.imageSuerte

        btnEstudiantes.setOnClickListener {
            findNavController().navigate(R.id.navigation_dashboard)
        }

        btnProfesores.setOnClickListener {
            findNavController().navigate(R.id.navigation_notifications)
        }


        //val rotateAnimation = RotateAnimation(-10f, 20f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        //rotateAnimation.duration = 1000 // Duración de 1 segundo
        //rotateAnimation.repeatCount = Animation.INFINITE
        //imageView.startAnimation(rotateAnimation)
        val scaleAnimation = ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 1000 // Duración de 1 segundo
        scaleAnimation.repeatMode = Animation.REVERSE // Invertir la animación al finalizar
        scaleAnimation.repeatCount = Animation.INFINITE
        imageView.startAnimation(scaleAnimation)

        imageView.setOnClickListener {
            val intent = Intent(requireContext(), suerteActivity::class.java)
            startActivity(intent)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
