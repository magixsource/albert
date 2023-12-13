package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Yiyan token response
 */
public class YiyanTokenResponse extends YiyanResponse {
    /**
     * 访问凭证
     */
    @JSONField(name = "access_token")
    private String accessToken;
    /**
     * 有效期，Access Token的有效期 ：单位是秒，有效期30天
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;
    /**
     * 错误码:响应失败时返回该字段，成功时不返回
     */
    private String error;
    /**
     * 错误描述:响应失败时返回该字段，成功时不返回
     */
    @JSONField(name = "error_description")
    private String errorDescription;
    /**
     * 会话KEY（预留）
     */
    @JSONField(name = "session_key")
    private String sessionKey;
    /**
     * 使用范围（预留）
     */
    private String scope;
    /**
     * 刷新凭证（预留）
     */
    @JSONField(name = "refresh_token")
    private String refreshToken;
    /**
     * 会话密钥（预留）
     */
    @JSONField(name = "session_secret")
    private String sessionSecret;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSessionSecret() {
        return sessionSecret;
    }

    public void setSessionSecret(String sessionSecret) {
        this.sessionSecret = sessionSecret;
    }
}
