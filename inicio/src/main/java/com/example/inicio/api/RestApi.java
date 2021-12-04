package com.example.inicio.api;

import com.example.inicio.api.models.Game;
import com.example.inicio.api.models.LoginDto;
import com.example.inicio.api.models.ScoreDto;
import com.example.inicio.api.models.ScoreResponse;
import com.example.inicio.api.models.SuccessLogin;
import com.example.inicio.api.models.User;
import com.example.inicio.api.models.UserDto;
import com.example.inicio.api.models.UserSuccess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    @POST("auth/login")
    Call<SuccessLogin> login(@Body LoginDto loginDto);

    @GET("users")
    Call<List<User>> getUsers();

    @GET("games")
    Call<List<Game>> getGames();

    @POST("users")
    Call<UserSuccess> createUser(@Body UserDto userDto);

    @GET("users/{userId}")
    Call<User> getUser(@Header("Token") String token, @Path("userId") int userId);

    @POST("score")
    Call<ScoreDto> createScore(@Body ScoreDto scoreDto);

    @GET("score")
    Call<List<ScoreResponse>> getScore(@Query("playerId") int userId, @Query("gameId") int gameId);

}
