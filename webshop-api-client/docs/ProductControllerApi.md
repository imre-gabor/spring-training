# ProductControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST**](ProductControllerApi.md#createUsingPOST) | **POST** /api/products | create
[**deleteUsingDELETE**](ProductControllerApi.md#deleteUsingDELETE) | **DELETE** /api/products/{id} | delete
[**getAllUsingGET**](ProductControllerApi.md#getAllUsingGET) | **GET** /api/products | getAll
[**getByIdUsingGET**](ProductControllerApi.md#getByIdUsingGET) | **GET** /api/products/{id} | getById
[**modifyUsingPUT**](ProductControllerApi.md#modifyUsingPUT) | **PUT** /api/products | modify
[**search1UsingPOST**](ProductControllerApi.md#search1UsingPOST) | **POST** /api/products/search1 | search1
[**search2UsingPOST**](ProductControllerApi.md#search2UsingPOST) | **POST** /api/products/search2 | search2
[**search3UsingPOST**](ProductControllerApi.md#search3UsingPOST) | **POST** /api/products/search3 | search3


<a name="createUsingPOST"></a>
# **createUsingPOST**
> Product createUsingPOST(product)

create

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Product product = new Product(); // Product | product
try {
    Product result = apiInstance.createUsingPOST(product);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#createUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product** | [**Product**](Product.md)| product |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteUsingDELETE"></a>
# **deleteUsingDELETE**
> deleteUsingDELETE(id)

delete

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Long id = 789L; // Long | id
try {
    apiInstance.deleteUsingDELETE(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#deleteUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAllUsingGET"></a>
# **getAllUsingGET**
> List&lt;Product&gt; getAllUsingGET()

getAll

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
try {
    List<Product> result = apiInstance.getAllUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#getAllUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getByIdUsingGET"></a>
# **getByIdUsingGET**
> Product getByIdUsingGET(id)

getById

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Long id = 789L; // Long | id
try {
    Product result = apiInstance.getByIdUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#getByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="modifyUsingPUT"></a>
# **modifyUsingPUT**
> Product modifyUsingPUT(product)

modify

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Product product = new Product(); // Product | product
try {
    Product result = apiInstance.modifyUsingPUT(product);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#modifyUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product** | [**Product**](Product.md)| product |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="search1UsingPOST"></a>
# **search1UsingPOST**
> List&lt;Product&gt; search1UsingPOST(example)

search1

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Product example = new Product(); // Product | example
try {
    List<Product> result = apiInstance.search1UsingPOST(example);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#search1UsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **example** | [**Product**](Product.md)| example |

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="search2UsingPOST"></a>
# **search2UsingPOST**
> PageProduct search2UsingPOST(example, offset, pageNumber, pageSize, paged, sortSorted, sortUnsorted, unpaged)

search2

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Product example = new Product(); // Product | example
Long offset = 789L; // Long | 
Integer pageNumber = 56; // Integer | 
Integer pageSize = 56; // Integer | 
Boolean paged = true; // Boolean | 
Boolean sortSorted = true; // Boolean | 
Boolean sortUnsorted = true; // Boolean | 
Boolean unpaged = true; // Boolean | 
try {
    PageProduct result = apiInstance.search2UsingPOST(example, offset, pageNumber, pageSize, paged, sortSorted, sortUnsorted, unpaged);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#search2UsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **example** | [**Product**](Product.md)| example |
 **offset** | **Long**|  | [optional]
 **pageNumber** | **Integer**|  | [optional]
 **pageSize** | **Integer**|  | [optional]
 **paged** | **Boolean**|  | [optional]
 **sortSorted** | **Boolean**|  | [optional]
 **sortUnsorted** | **Boolean**|  | [optional]
 **unpaged** | **Boolean**|  | [optional]

### Return type

[**PageProduct**](PageProduct.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="search3UsingPOST"></a>
# **search3UsingPOST**
> PageProduct search3UsingPOST(example, page, size, sort)

search3

### Example
```java
// Import classes:
//import com.novaservices.training.webshop.client.invoker.ApiException;
//import com.novaservices.training.webshop.client.api.ProductControllerApi;


ProductControllerApi apiInstance = new ProductControllerApi();
Product example = new Product(); // Product | example
Object page = 0; // Object | Result page (0..N)
Object size = 20; // Object | Page size
List<String> sort = Arrays.asList("sort_example"); // List<String> | Sort fields, e.g. id,desc
try {
    PageProduct result = apiInstance.search3UsingPOST(example, page, size, sort);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductControllerApi#search3UsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **example** | [**Product**](Product.md)| example |
 **page** | [**Object**](.md)| Result page (0..N) | [optional] [default to 0]
 **size** | [**Object**](.md)| Page size | [optional] [default to 20]
 **sort** | [**List&lt;String&gt;**](String.md)| Sort fields, e.g. id,desc | [optional]

### Return type

[**PageProduct**](PageProduct.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

