package gl.linpeng.ai.commons;

import gl.linpeng.ai.commons.protocol.request.AlbertRequest;
import gl.linpeng.ai.commons.protocol.response.AlbertResponse;

/**
 * Albert client interface
 */
public interface AlbertClient<R extends AlbertResponse, Q extends AlbertRequest> {

    /**
     * invoke albert model
     *
     * @param request albert request
     * @return albert response
     */
    R invoke(Q request);

    /**
     * invoke albert in raw mode
     * no wrapper object,so everything in raw
     * this is very useful when debug protocol
     *
     * @param requestJson request json body
     * @return response json
     */
    String invokeRaw(String requestJson);
}
