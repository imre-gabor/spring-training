package com.novaservices.training.webshop.client.api;

import com.novaservices.training.webshop.client.invoker.ApiClient;

import com.novaservices.training.webshop.client.model.PageProduct;
import com.novaservices.training.webshop.client.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-30T10:28:28.325+02:00")
@Component("com.novaservices.training.webshop.client.api.ProductControllerApi")
public class ProductControllerApi {
    private ApiClient apiClient;

    public ProductControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProductControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * create
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param product product (required)
     * @return Product
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Product createUsingPOST(Product product) throws RestClientException {
        return createUsingPOSTWithHttpInfo(product).getBody();
    }

    /**
     * create
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param product product (required)
     * @return ResponseEntity&lt;Product&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Product> createUsingPOSTWithHttpInfo(Product product) throws RestClientException {
        Object postBody = product;
        
        // verify the required parameter 'product' is set
        if (product == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'product' when calling createUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/products").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Product> returnType = new ParameterizedTypeReference<Product>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * delete
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param id id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteUsingDELETE(Long id) throws RestClientException {
        deleteUsingDELETEWithHttpInfo(id);
    }

    /**
     * delete
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param id id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteUsingDELETEWithHttpInfo(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteUsingDELETE");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/api/products/{id}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * getAll
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;Product&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Product> getAllUsingGET() throws RestClientException {
        return getAllUsingGETWithHttpInfo().getBody();
    }

    /**
     * getAll
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;Product&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Product>> getAllUsingGETWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/api/products").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Product>> returnType = new ParameterizedTypeReference<List<Product>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * getById
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id (required)
     * @return Product
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Product getByIdUsingGET(Long id) throws RestClientException {
        return getByIdUsingGETWithHttpInfo(id).getBody();
    }

    /**
     * getById
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id (required)
     * @return ResponseEntity&lt;Product&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Product> getByIdUsingGETWithHttpInfo(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getByIdUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/api/products/{id}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Product> returnType = new ParameterizedTypeReference<Product>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * modify
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param product product (required)
     * @return Product
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Product modifyUsingPUT(Product product) throws RestClientException {
        return modifyUsingPUTWithHttpInfo(product).getBody();
    }

    /**
     * modify
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param product product (required)
     * @return ResponseEntity&lt;Product&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Product> modifyUsingPUTWithHttpInfo(Product product) throws RestClientException {
        Object postBody = product;
        
        // verify the required parameter 'product' is set
        if (product == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'product' when calling modifyUsingPUT");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/products").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Product> returnType = new ParameterizedTypeReference<Product>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * search1
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @return List&lt;Product&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Product> search1UsingPOST(Product example) throws RestClientException {
        return search1UsingPOSTWithHttpInfo(example).getBody();
    }

    /**
     * search1
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @return ResponseEntity&lt;List&lt;Product&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Product>> search1UsingPOSTWithHttpInfo(Product example) throws RestClientException {
        Object postBody = example;
        
        // verify the required parameter 'example' is set
        if (example == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'example' when calling search1UsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/products/search1").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Product>> returnType = new ParameterizedTypeReference<List<Product>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * search2
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @param offset  (optional)
     * @param pageNumber  (optional)
     * @param pageSize  (optional)
     * @param paged  (optional)
     * @param sortSorted  (optional)
     * @param sortUnsorted  (optional)
     * @param unpaged  (optional)
     * @return PageProduct
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageProduct search2UsingPOST(Product example, Long offset, Integer pageNumber, Integer pageSize, Boolean paged, Boolean sortSorted, Boolean sortUnsorted, Boolean unpaged) throws RestClientException {
        return search2UsingPOSTWithHttpInfo(example, offset, pageNumber, pageSize, paged, sortSorted, sortUnsorted, unpaged).getBody();
    }

    /**
     * search2
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @param offset  (optional)
     * @param pageNumber  (optional)
     * @param pageSize  (optional)
     * @param paged  (optional)
     * @param sortSorted  (optional)
     * @param sortUnsorted  (optional)
     * @param unpaged  (optional)
     * @return ResponseEntity&lt;PageProduct&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PageProduct> search2UsingPOSTWithHttpInfo(Product example, Long offset, Integer pageNumber, Integer pageSize, Boolean paged, Boolean sortSorted, Boolean sortUnsorted, Boolean unpaged) throws RestClientException {
        Object postBody = example;
        
        // verify the required parameter 'example' is set
        if (example == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'example' when calling search2UsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/products/search2").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageNumber", pageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "paged", paged));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort.sorted", sortSorted));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort.unsorted", sortUnsorted));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "unpaged", unpaged));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageProduct> returnType = new ParameterizedTypeReference<PageProduct>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * search3
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @param page Result page (0..N) (optional, default to 0)
     * @param size Page size (optional, default to 20)
     * @param sort Sort fields, e.g. id,desc (optional)
     * @return PageProduct
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageProduct search3UsingPOST(Product example, Object page, Object size, List<String> sort) throws RestClientException {
        return search3UsingPOSTWithHttpInfo(example, page, size, sort).getBody();
    }

    /**
     * search3
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param example example (required)
     * @param page Result page (0..N) (optional, default to 0)
     * @param size Page size (optional, default to 20)
     * @param sort Sort fields, e.g. id,desc (optional)
     * @return ResponseEntity&lt;PageProduct&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<PageProduct> search3UsingPOSTWithHttpInfo(Product example, Object page, Object size, List<String> sort) throws RestClientException {
        Object postBody = example;
        
        // verify the required parameter 'example' is set
        if (example == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'example' when calling search3UsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/api/products/search3").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "sort", sort));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageProduct> returnType = new ParameterizedTypeReference<PageProduct>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
