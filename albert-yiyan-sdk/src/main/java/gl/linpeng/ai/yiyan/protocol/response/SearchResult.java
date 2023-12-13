package gl.linpeng.ai.yiyan.protocol.response;

/**
 * 搜索结果
 */
public class SearchResult {
    /**
     * 搜索结果序号
     */
    private int index;
    /**
     * 搜索结果URL
     */
    private String url;
    /**
     * 搜索结果标题
     */
    private String title;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
