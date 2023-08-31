package dev.abs.six.config.exceptionMapping;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    /**
     * logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(final Exception exception) {

        logger.error(exception.getMessage(), exception);

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
    }
}
