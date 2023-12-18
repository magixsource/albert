package gl.linpeng.ai.qingyan.converter;

import gl.linpeng.ai.commons.converter.AlbertConverter;
import gl.linpeng.ai.commons.protocol.request.AlbertInput;
import gl.linpeng.ai.commons.protocol.request.AlbertParameters;
import gl.linpeng.ai.commons.protocol.request.AlbertRequest;
import gl.linpeng.ai.qingyan.protocol.request.Message;
import gl.linpeng.ai.qingyan.protocol.request.QingyanChatGlmTurboRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Qingyan glm turbo request converter
 */
public class QingyanGlmTurboRequestConverter implements AlbertConverter<AlbertRequest, QingyanChatGlmTurboRequest> {
    @Override
    public QingyanChatGlmTurboRequest convert(AlbertRequest request) {
        QingyanChatGlmTurboRequest qingyanChatGlmTurboRequest = new QingyanChatGlmTurboRequest();
        List<Message> prompt = new ArrayList<>();
        Message message = new Message("user", request.getInput().getPrompt());
        prompt.add(message);
        qingyanChatGlmTurboRequest.setPrompt(prompt);
        qingyanChatGlmTurboRequest.setIncremental(false);
        if (request.getParameters() != null) {
            qingyanChatGlmTurboRequest.setTemperature(request.getParameters().getTemperature());
            qingyanChatGlmTurboRequest.setTopP(request.getParameters().getTopP());
        }
        qingyanChatGlmTurboRequest.setRef(null);
        return qingyanChatGlmTurboRequest;
    }

    @Override
    public AlbertRequest convertBack(QingyanChatGlmTurboRequest qingyanChatGlmTurboRequest) {
        AlbertRequest albertRequest = new AlbertRequest();
        AlbertInput input = new AlbertInput();
        input.setPrompt(qingyanChatGlmTurboRequest.getPrompt().get(0).getContent());
        albertRequest.setInput(input);
        AlbertParameters parameters = new AlbertParameters();
        parameters.setTemperature(qingyanChatGlmTurboRequest.getTemperature());
        parameters.setTopP(qingyanChatGlmTurboRequest.getTopP());
        albertRequest.setParameters(parameters);
        return albertRequest;
    }
}
