package com.itx.wvsecurit.domain.usecase;

import com.itx.common.jcdata.CustomResponse;
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity;
import com.itx.wvsecurit.data.network.SegIncidentTypeApiClient;
import retrofit2.Call;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/itx/wvsecurit/domain/usecase/GetSegIncidentTypeUseCase;", "", "segIncidentTypeApiClient", "Lcom/itx/wvsecurit/data/network/SegIncidentTypeApiClient;", "(Lcom/itx/wvsecurit/data/network/SegIncidentTypeApiClient;)V", "invoke", "Lretrofit2/Call;", "Lcom/itx/common/jcdata/CustomResponse;", "", "Lcom/itx/wvsecurit/data/database/entities/SegIncidentTypeEntity;", "app_debug"})
public final class GetSegIncidentTypeUseCase {
    private final com.itx.wvsecurit.data.network.SegIncidentTypeApiClient segIncidentTypeApiClient = null;
    
    @javax.inject.Inject()
    public GetSegIncidentTypeUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.SegIncidentTypeApiClient segIncidentTypeApiClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Call<com.itx.common.jcdata.CustomResponse<java.util.List<com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity>>> invoke() {
        return null;
    }
}