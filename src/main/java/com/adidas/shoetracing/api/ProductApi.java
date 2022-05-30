/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-30T23:30:32.507993+02:00[Europe/Berlin]")
@Validated
@Tag(name = "Product", description = "the Product API")
public interface ProductApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products
     * Buy product
     *
     * @param productInformation  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "buyProduct",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  byte[].class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/jpeg" },
        consumes = { "application/json" }
    )
    default ResponseEntity<byte[]> buyProduct(
        @Parameter(name = "ProductInformation", description = "", required = true, schema = @Schema(description = "")) @Valid @RequestBody ProductInformation productInformation
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products/{id}
     * Get product
     *
     * @param id  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getProduct",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  ProductInformation.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<ProductInformation> getProduct(
        @Parameter(name = "id", description = "", required = true, schema = @Schema(description = "")) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : \"owner\", \"price\" : \"price\", \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"ownerAdress\" : \"ownerAdress\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products
     * Get products
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getProducts",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  ProductInformation.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ProductInformation>> getProducts(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"owner\" : \"owner\", \"price\" : \"price\", \"imageUrl\" : \"imageUrl\", \"name\" : \"name\", \"description\" : \"description\", \"ownerAdress\" : \"ownerAdress\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
