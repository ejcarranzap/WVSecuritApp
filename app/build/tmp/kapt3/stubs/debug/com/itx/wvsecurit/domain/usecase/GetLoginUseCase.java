package com.itx.wvsecurit.domain.usecase;

import com.itx.wvsecurit.data.network.LoginApiClient;
import com.itx.wvsecurit.data.network.LoginApiRequest;
import com.itx.wvsecurit.data.network.LoginApiResponse;
import retrofit2.Call;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/itx/wvsecurit/domain/usecase/GetLoginUseCase;", "", "loginApiClient", "Lcom/itx/wvsecurit/data/network/LoginApiClient;", "(Lcom/itx/wvsecurit/data/network/LoginApiClient;)V", "invoke", "Lretrofit2/Call;", "Lcom/itx/wvsecurit/data/network/LoginApiResponse;", "user", "", "password", "app_debug"})
public final class GetLoginUseCase {
    private final com.itx.wvsecurit.data.network.LoginApiClient loginApiClient = null;
    
    @javax.inject.Inject()
    public GetLoginUseCase(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.network.LoginApiClient loginApiClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Call<com.itx.wvsecurit.data.network.LoginApiResponse> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String user, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
}