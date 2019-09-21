package ru.sky.test.wrike;

import org.junit.Assert;
import org.junit.Test;
import ru.sky.test.wrike.utils.ConnectorToURL;

import java.io.IOException;

public class TestConnection {

    @Test
    public void connection() throws IOException {
        Assert.assertEquals(200,ConnectorToURL.connectionWrike());
    }
}
