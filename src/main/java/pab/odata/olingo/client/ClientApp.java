package pab.odata.olingo.client;


import org.apache.olingo.client.api.ODataClient;
import org.apache.olingo.client.api.communication.request.cud.CUDRequestFactory;
import org.apache.olingo.client.api.communication.request.cud.ODataEntityCreateRequest;
import org.apache.olingo.client.api.communication.request.retrieve.EdmMetadataRequest;
import org.apache.olingo.client.api.communication.response.ODataEntityCreateResponse;
import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.api.domain.ClientEntity;
import org.apache.olingo.client.api.serialization.ODataDeserializerException;
import org.apache.olingo.client.core.ODataClientFactory;
import org.apache.olingo.commons.api.edm.Edm;
import org.apache.olingo.commons.api.format.ContentType;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ClientApp {
    ODataClient client;

    final String serviceUrl = "http://localhost:8081/DemoService/DemoService.svc";

    public static void main(String[] args) throws IOException, ODataDeserializerException {
        ClientApp app = new ClientApp();

        Edm edm = app.readEdm(app.serviceUrl);
        ClientEntity ce = app.loadEntity("/create_product.json");
        app.createEntity(edm, app.serviceUrl, "Products", ce);
    }

    public ClientApp() {
        this.client = ODataClientFactory.getClient();
    }

    private ClientEntity loadEntity(String path) throws ODataDeserializerException {
        InputStream input = getClass().getResourceAsStream(path);
        return client.getBinder().getODataEntity(client.getDeserializer(ContentType.APPLICATION_JSON).toEntity(input));
    }

    public ClientEntity createEntity(Edm edm, String serviceUri, String entitySetName, ClientEntity ce) {
        URI absoluteUri = client.newURIBuilder(serviceUri).appendEntitySetSegment(entitySetName).build();
        return createEntity(edm, absoluteUri, ce);
    }

    private ClientEntity createEntity(Edm edm, URI absoluteUri, ClientEntity ce) {
        ODataEntityCreateRequest<ClientEntity> request = client.getCUDRequestFactory()
                .getEntityCreateRequest(absoluteUri, ce);
        request.setAccept("application/json");
        ODataEntityCreateResponse<ClientEntity> response = request.execute();

        return response.getBody();
    }

    public Edm readEdm(String serviceUrl) throws IOException {
        EdmMetadataRequest request = client.getRetrieveRequestFactory().getMetadataRequest(serviceUrl);
        ODataRetrieveResponse<Edm> response = request.execute();
        return response.getBody();
    }


}
