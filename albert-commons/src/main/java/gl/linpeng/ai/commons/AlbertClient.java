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
}
