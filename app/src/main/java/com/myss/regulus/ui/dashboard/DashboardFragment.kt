package com.myss.regulus.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myss.regulus.R
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myss.regulus.adapter.EstudianteAdapter
import com.myss.regulus.model.datosEstudiantesItem
import com.myss.regulus.network.ApiClient
import com.myss.regulus.network.ApiEstudiantes

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var estudianteA: EstudianteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_alum)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        mostrarAlum()
    }

    private fun mostrarAlum() {
        val call: Call<List<datosEstudiantesItem>> = ApiClient().getClient().create(ApiEstudiantes::class.java).getEstudiantes()
        call.enqueue(object : Callback<List<datosEstudiantesItem>> {
            override fun onResponse(call: Call<List<datosEstudiantesItem>>, response: Response<List<datosEstudiantesItem>>) {
                if (response.isSuccessful) {
                    val estudiantesResponse: List<datosEstudiantesItem>? = response.body()
                    if (estudiantesResponse != null) {
                        estudianteA = EstudianteAdapter(estudiantesResponse, requireContext())
                        recyclerView.adapter = estudianteA
                    }
                }
            }

            override fun onFailure(call: Call<List<datosEstudiantesItem>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}