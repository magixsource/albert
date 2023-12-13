package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 搜索结果列表
 */
public class SearchInfo {

    @JSONField(name = "search_result")
    private List<SearchResult> searchResult;

    public List<SearchResult> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<SearchResult> searchResult) {
        this.searchResult = searchResult;
    }

}
