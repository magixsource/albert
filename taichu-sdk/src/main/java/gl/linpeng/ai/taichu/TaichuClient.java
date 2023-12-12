package gl.linpeng.ai.taichu;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.taichu.config.TaichuProperties;
import gl.linpeng.ai.taichu.constants.Constant;
import gl.linpeng.ai.taichu.request.TaichuRequest;
import gl.linpeng.ai.taichu.request.TaichuRequest10B;
import gl.linpeng.ai.taichu.request.TaichuRequest8B;
import gl.linpeng.ai.taichu.response.TaichuResponse;
import gl.linpeng.ai.taichu.response.TaichuStreamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Taichu client
 */
@Component
public class TaichuClient {

    @Autowired
    private TaichuProperties taichuProperties;

    /**
     * 调用太初接口,当前支持8B和10B模型
     *
     * @param request request
     */
    public void invoke(TaichuRequest request) {
        if (request instanceof TaichuRequest10B) {
            TaichuRequest10B request10B = (TaichuRequest10B) request;
            invoke10B(request10B);
        } else if (request instanceof TaichuRequest8B) {
            TaichuRequest8B request8B = (TaichuRequest8B) request;
            invoke8B(request8B);
        } else {
            throw new RuntimeException("Not support request type");
        }

    }

    /**
     * 调用8B模型
     *
     * @param request8B request8B
     */
    private void invoke8B(TaichuRequest8B request8B) {
        request8B.setModelCode(Constant.TAICHU_LLA_8B);
        request8B.setApiKey(taichuProperties.getApiKey());
        String body = JSON.toJSONString(request8B);
        boolean isStream = request8B.getDoStream() == null || request8B.getDoStream();
        String responseString = post(body);
        if (isStream) {
            // 实时响应
            TaichuStreamResponse response = JSON.parseObject(responseString, TaichuStreamResponse.class);
            System.out.println("正确响应:" + response.getData());
        } else {
            // 非实时响应
            TaichuResponse response = JSON.parseObject(responseString, TaichuResponse.class);
            if (response.getCode() == 0) {
                TaichuResponse.Data data = response.getData();
                System.out.println("正确响应:" + data.getContent());
            } else {
                // 错误信息
                System.out.println("错误信息：" + response.getMsg());
            }
        }
    }

    /**
     * 调用10B模型
     *
     * @param request10B request10B
     */
    private void invoke10B(TaichuRequest10B request10B) {
        request10B.setModelCode(Constant.TAICHU_VQA_10B);
        request10B.setApiKey(taichuProperties.getApiKey());
        String body = JSON.toJSONString(request10B);
        TaichuResponse response = JSON.parseObject(post(body), TaichuResponse.class);
        if (response.getCode() == 0) {
            TaichuResponse.Data data = response.getData();
            System.out.println("正确响应:" + data.getContent());
        } else {
            // 错误信息
            System.out.println("错误信息：" + response.getMsg());
        }

    }

    /**
     * POST请求
     *
     * @param body json
     * @return response string
     */
    private String post(String body) {
        String responseString = HttpUtil.post(Constant.HTTP_ENDPOINT_V1, body, Constant.HTTP_TIMEOUT);
        System.out.println("原始响应:" + responseString);
        return responseString;
    }


}
