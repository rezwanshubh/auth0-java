package com.auth0.json.mgmt;

import com.auth0.json.JsonTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeviceCredentialsTest extends JsonTest<DeviceCredentials> {

    private static final String json = "{\"device_name\":\"devName\",\"type\":\"publicKey\",\"value\":\"val123\",\"device_id\":\"dev123\",\"client_id\":\"client123\",\"user_id\":\"theUserId\"}";
    private static final String readOnlyJson = "{\"id\":\"credentialsId\"}";

    @Test
    public void shouldSerialize() throws Exception {
        DeviceCredentials credentials = new DeviceCredentials("devName", "publicKey", "val123", "dev123", "client123");
        credentials.setUserId("theUserId");

        String serialized = toJSON(credentials);
        assertThat(serialized, is(notNullValue()));
        assertThat(serialized, is(equalTo(json)));
    }

    @Test
    public void shouldDeserialize() throws Exception {
        DeviceCredentials credentials = fromJSON(json, DeviceCredentials.class);

        assertThat(credentials, is(notNullValue()));
        assertThat(credentials.getDeviceName(), is("devName"));
        assertThat(credentials.getType(), is("publicKey"));
        assertThat(credentials.getValue(), is("val123"));
        assertThat(credentials.getDeviceId(), is("dev123"));
        assertThat(credentials.getClientId(), is("client123"));
        assertThat(credentials.getUserId(), is("theUserId"));
    }

    @Test
    public void shouldIncludeReadOnlyValuesOnDeserialize() throws Exception {
        DeviceCredentials credentials = fromJSON(readOnlyJson, DeviceCredentials.class);
        assertThat(credentials, is(notNullValue()));

        assertThat(credentials.getId(), is("credentialsId"));
    }
}