package noragarcia.helloworld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import noragarcia.helloworld.net.ApiClient
import noragarcia.helloworld.net.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConexionRedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_red)

        val recycler = findViewById<RecyclerView>(R.id.recyclerPosts)
        recycler.layoutManager = LinearLayoutManager(this)

        ApiClient.apiService.getPosts().enqueue(object : Callback<List<Post>> {

            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    recycler.adapter = PostAdapter(response.body() ?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("API", "Error conexión", t)
            }
        })
    }
}
