package gl.linpeng.ai.qingyan.protocol.request;

/**
 * 用于控制请求时的外部信息引用，目前用于控制是否引用外部信息，空或者没有此字段时默认开启搜索，传参格式
 * {"enable": "true", "search_query": "历史"}
 */
public class Ref {
    /**
     * 用于控制是否引用外部信息，空或者没有此字段时默认开启搜索（开启后系统依据策略决定当前请求是否最终执行搜索）
     * - true 为开启搜索
     * - false 为关闭搜索
     */
    private Boolean enable;
    /**
     * 搜索时的query词，不指定则默认按照prompt信息进行搜索
     */
    private String searchQuery;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

}
