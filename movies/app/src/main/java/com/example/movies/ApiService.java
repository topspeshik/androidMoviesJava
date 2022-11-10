package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=C447PJJ-CSM4K38-G5H5KTW-SYHNB79&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page); // Query добавит к запросу параметр

    @GET("movie?token=C447PJJ-CSM4K38-G5H5KTW-SYHNB79&field=id&")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);

    @GET("review?token=C447PJJ-CSM4K38-G5H5KTW-SYHNB79&field=movieId")
    Single<ReviewResponse> loadReviews(@Query("search") int id);

}
