package gl.linpeng.ai.qingyan.converter;

import gl.linpeng.ai.commons.converter.AlbertConverter;
import gl.linpeng.ai.commons.protocol.response.AlbertOutput;
import gl.linpeng.ai.commons.protocol.response.AlbertResponse;
import gl.linpeng.ai.commons.protocol.response.AlbertUsage;
import gl.linpeng.ai.qingyan.constant.Constants;
import gl.linpeng.ai.qingyan.protocol.response.Choice;
import gl.linpeng.ai.qingyan.protocol.response.Data;
import gl.linpeng.ai.qingyan.protocol.response.QingyanChatGlmTurboResponse;
import gl.linpeng.ai.qingyan.protocol.response.Usage;

import java.util.ArrayList;
import java.util.List;

/**
 * Qingyan glm turbo response converter
 */
public class QingyanGlmTurboResponseConverter implements AlbertConverter<AlbertResponse, QingyanChatGlmTurboResponse> {
    @Override
    public QingyanChatGlmTurboResponse convert(AlbertResponse response) {
        QingyanChatGlmTurboResponse qingyanChatGlmTurboResponse = new QingyanChatGlmTurboResponse();
        qingyanChatGlmTurboResponse.setCode(response.getCode());
        qingyanChatGlmTurboResponse.setMsg(response.getMessage());
        qingyanChatGlmTurboResponse.setSuccess(response.getCode() == Constants.HTTP_STATUS_SUCCESS);
        Data data = new Data();
        if (response.getUsage() != null) {
            Usage usage = new Usage();
            usage.setCompletionTokens(response.getUsage().getOutputTokens());
            usage.setPromptTokens(response.getUsage().getInputTokens());
            usage.setTotalTokens(response.getUsage().getOutputTokens() + response.getUsage().getInputTokens());
            data.setUsage(usage);
        }
        data.setRequestId(response.getRequestId());
        List<Choice> choices = new ArrayList<>();
        Choice choice = new Choice();
        choice.setContent(response.getOutput().getText());
        choices.add(choice);
        data.setChoices(choices);
        qingyanChatGlmTurboResponse.setData(data);
        return qingyanChatGlmTurboResponse;
    }

    @Override
    public AlbertResponse convertBack(QingyanChatGlmTurboResponse qingyanChatGlmTurboResponse) {
        AlbertResponse albertResponse = new AlbertResponse();
        albertResponse.setCode(qingyanChatGlmTurboResponse.getCode() != 0 ? Constants.HTTP_STATUS_SUCCESS : Constants.HTTP_STATUS_ERROR);
        albertResponse.setMessage(qingyanChatGlmTurboResponse.getMsg());
        albertResponse.setRequestId(qingyanChatGlmTurboResponse.getData().getRequestId());
        AlbertUsage usage = new AlbertUsage();
        usage.setInputTokens(qingyanChatGlmTurboResponse.getData().getUsage().getPromptTokens());
        usage.setOutputTokens(qingyanChatGlmTurboResponse.getData().getUsage().getCompletionTokens());
        albertResponse.setUsage(usage);
        AlbertOutput output = new AlbertOutput();
        output.setText(qingyanChatGlmTurboResponse.getData().getChoices().get(0).getContent());
        output.setFinishReason("stop");
        albertResponse.setOutput(output);
        return albertResponse;
    }
}
