package com.gimba.xaberchords.network;

import com.gimba.xaberchords.POJOs.ChordModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gimba on 17.03.2018.
 */

public interface ChordsAPI {
    @GET("/xaberapi/getChords")
    Call<ChordModel> getChord(@Query("Name") String name);
}
