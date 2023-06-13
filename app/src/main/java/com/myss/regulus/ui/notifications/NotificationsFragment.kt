package com.myss.regulus.ui.notifications


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myss.regulus.Padapter.ProfesorAdapter
import com.myss.regulus.databinding.FragmentNotificationsBinding
import com.myss.regulus.model.datosEstudiantesItem
import com.myss.regulus.Pnetwork.ApiClient2
import com.myss.regulus.Pnetwork.ApiProfesor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    private var estudiantesH: List<datosEstudiantesItem> = listOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var estudianteA: ProfesorAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        recyclerView = binding.rvProfesor
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        mostrarPro()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarPro() {
        val call: Call<List<datosEstudiantesItem>> =
            ApiClient2().getClient().create(ApiProfesor::class.java).getProfesor()
        call.enqueue(object : Callback<List<datosEstudiantesItem>> {
            override fun onResponse(
                call: Call<List<datosEstudiantesItem>>,
                response: Response<List<datosEstudiantesItem>>
            ) {
                if (response.isSuccessful) {
                    val estudiantesResponse: List<datosEstudiantesItem>? = response.body()
                    if (estudiantesResponse != null) {
                        estudiantesH = estudiantesResponse
                        estudianteA = ProfesorAdapter(estudiantesH, requireContext())
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
