package noragarcia.helloworld.net

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("post/{id}")
    fun  getPostById(@Path("id") postId: Int): Call<Post>
}