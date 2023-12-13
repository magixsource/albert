package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * PluginUsage 插件消耗tokens统计
 */
public class PluginUsage {
    /**
     * plugin名称，chatFile：chatfile插件消耗的tokens
     */
    private String name;
    /**
     * 解析文档tokens
     */
    @JSONField(name = "parse_tokens")
    private int parseTokens;
    /**
     * 摘要文档tokens
     */
    @JSONField(name = "abstract_tokens")
    private int abstractTokens;
    /**
     * 搜索文档tokens
     */
    @JSONField(name = "search_tokens")
    private int searchTokens;
    /**
     * 总消耗tokens
     */
    @JSONField(name = "total_tokens")
    private int totalTokens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParseTokens() {
        return parseTokens;
    }

    public void setParseTokens(int parseTokens) {
        this.parseTokens = parseTokens;
    }

    public int getAbstractTokens() {
        return abstractTokens;
    }

    public void setAbstractTokens(int abstractTokens) {
        this.abstractTokens = abstractTokens;
    }

    public int getSearchTokens() {
        return searchTokens;
    }

    public void setSearchTokens(int searchTokens) {
        this.searchTokens = searchTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }
}
