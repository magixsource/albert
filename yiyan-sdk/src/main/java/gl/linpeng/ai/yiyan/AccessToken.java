package gl.linpeng.ai.yiyan;

/**
 * AccessToken
 */
public class AccessToken {

    private String accessToken;
    /**
     * 过期时间,单位秒
     */
    private int expiresIn;

    public AccessToken(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * 是否过期
     *
     * @return true if expired
     */
    public boolean isExpired() {
        return System.currentTimeMillis() / 1000 > expiresIn - 1000;
    }
}
