package fii.user.api;

public class UserAuthentification {
    private Long userId;
    private String authToken;

    public UserAuthentification() {
    }

    public UserAuthentification(Long userId, String authToken) {
        this.userId = userId;
        this.authToken = authToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
