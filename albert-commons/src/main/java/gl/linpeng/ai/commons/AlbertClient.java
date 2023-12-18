package gl.linpeng.ai.commons;

import gl.linpeng.ai.commons.protocol.request.AlbertRequest;
import gl.linpeng.ai.commons.protocol.response.AlbertResponse;

/**
 * Albert client interface
 */
public interface AlbertClient {

    /**
     * invoke albert model
     *
     * @param request albert request
     * @return albert response
     */
    AlbertResponse invoke(AlbertRequest request);
}
