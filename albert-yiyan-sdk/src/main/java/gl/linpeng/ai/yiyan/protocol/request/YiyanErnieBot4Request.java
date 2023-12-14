package gl.linpeng.ai.yiyan.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * ErnieBot4请求
 */
public class YiyanErnieBot4Request extends YiyanRequest {

    /**
     * 生成停止标识，当模型生成结果以stop中某个元素结尾时，停止文本生成。说明：
     * （1）每个元素长度不超过20字符
     * （2）最多4个元素
     */
    private List<String> stop;
    /**
     * 是否强制关闭实时搜索功能，默认false，表示不关闭
     */
    @JSONField(name = "disable_search")
    private Boolean disableSearch;
    /**
     * 是否开启上角标返回，说明：
     * （1）开启后，有概率触发搜索溯源信息search_info，search_info内容见响应参数介绍
     * （2）默认false，不开启
     */
    @JSONField(name = "enable_citation")
    private Boolean enableCitation;

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public Boolean getDisableSearch() {
        return disableSearch;
    }

    public void setDisableSearch(Boolean disableSearch) {
        this.disableSearch = disableSearch;
    }

    public Boolean getEnableCitation() {
        return enableCitation;
    }

    public void setEnableCitation(Boolean enableCitation) {
        this.enableCitation = enableCitation;
    }
}
