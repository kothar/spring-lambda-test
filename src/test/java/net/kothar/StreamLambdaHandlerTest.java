package net.kothar;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Ignore
public class StreamLambdaHandlerTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void request_static_resource() throws IOException {
        StreamLambdaHandler handler = new StreamLambdaHandler();

        InputStream request = getClass().getResourceAsStream("/static_resource.json");
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        handler.handleRequest(request, output, new MockLambdaContext());

        AwsProxyResponse response = mapper.readValue(output.toByteArray(), AwsProxyResponse.class);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
        Assert.assertEquals("Response code", 200, response.getStatusCode());
    }

    @Test
    public void request_dynamic_resource() throws IOException {
        StreamLambdaHandler handler = new StreamLambdaHandler();

        InputStream request = getClass().getResourceAsStream("/dynamic_resource.json");
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        handler.handleRequest(request, output, new MockLambdaContext());

        AwsProxyResponse response = mapper.readValue(output.toByteArray(), AwsProxyResponse.class);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
        Assert.assertEquals("Response code", 200, response.getStatusCode());
    }

}