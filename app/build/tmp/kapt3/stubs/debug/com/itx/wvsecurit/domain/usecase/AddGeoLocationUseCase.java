package com.itx.wvsecurit.domain.usecase;

import android.widget.Toast;
import com.itx.common.jcdata.CustomResponse;
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity;
import com.itx.wvsecurit.data.network.GeoLocationApiClient;
import retrofit2.Call;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/itx/wvsecurit/domain/usecase/AddGeoLocationUseCase;", "", "geoLocationApiClient", "Lcom/itx/wvsecurit/data/network/GeoLocationApiClient;", "(Lcom/itx/wvsecurit/data/network/GeoLocationApiClient;)V", "invoke", "Lretrofit2/Call;", "Lcom/itx/common/jcdata/CustomResponse;", "", "Lcom/itx/wvsecurit/data/database/entities/GeoLocationEntity;", "obj", "app_debug"})
public final class AddGeoLocationUseCase {
    private final com.itx.wvsecurit.data.network.GeoLocationApiClient geoLocationApiClient = null;
    
    @javax.inject.Inject()
    public AddGeoLocationUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.GeoLocationApiClient geoLocationApiClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Call<com.itx.common.jcdata.CustomResponse<java.util.List<com.itx.wvsecurit.data.database.entities.GeoLocationEntity>>> invoke(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.entities.GeoLocationEntity obj) {
        return null;
    }
}